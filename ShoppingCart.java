import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ShoppingCart extends JFrame implements ActionListener{
    //Generic variables and things needed
    private int orders; //Just so the arraylist works right
    private final ArrayList<ItemOrder> list = new ArrayList<ItemOrder>(orders);
    private int currentItemTotal = 0; //So we know how many items there are in the list
    private double itemCost;
    private Item thing;
    //JFrame things
    private Frame mainFrame; //This is the frame everything happens on
    private Label headerLabel; //This is the main label that is above everything
    private Label msg; //End message like PartyPlanner
    private Panel controlPanel; //Main panel for everything happening to happen on
    private Panel amount; //Choosing items or whatever
    private final Panel choosing = new Panel(); //Buttons
    private final Panel adding = new Panel(); //Adding items
    private final Panel finding = new Panel(); //Searching for items
    private final Panel removing = new Panel(); //Removing items
    private TextField cost; //Item cost
    private TextField name; //Name of Item
    private TextField howMany; //How many of said item are you buying
    private TextField totalItems; //How many items
    private TextField findWhat; //What item do you need
    private TextField removeWhat; //What are you removing
    private final JButton add = new JButton("Add Item");
    private final JButton search = new JButton("Find Item");
    private final JButton remove = new JButton("Remove Item");

    //Constructor YAY
    public ShoppingCart(){
        caert();
    }

    public static void main(String[] args) {
        ShoppingCart eck = new ShoppingCart();
    }

    //Main gui
    private void caert(){
        //CREATE THE MAINFRAME, AS USUAL
        mainFrame = new Frame("Shopping List Application");
        mainFrame.setSize(650,250);
        mainFrame.setBackground(Color.green); //Green because grocery feels like green to me
        mainFrame.setLayout(new FlowLayout());

        //Makes the program end on window close
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        //The main label, where you enter numbers and the msg label
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        msg = new Label("Your shopping list is ready in the console!");
        cost = new TextField();
        name = new TextField();
        howMany = new TextField();
        totalItems = new TextField();
        findWhat = new TextField();
        removeWhat = new TextField();

        //Main panel that contains all the cool fun things
        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        //Adding the panels so they work correctly
        choosing.setBackground(Color.WHITE);
        choosing.setSize(300,300);
        GridLayout layout = new GridLayout(0,3);
        layout.setHgap(10);
        layout.setVgap(10);
        choosing.setLayout(layout);

        choosing.add(add);
        choosing.add(search);
        choosing.add(remove);

        add.addActionListener(this);
        search.addActionListener(this);
        remove.addActionListener(this);

        adding.setBackground(Color.BLUE);
        adding.setSize(300,300);
        adding.setLayout(new FlowLayout());
        adding.add(cost);
        adding.add(name);
        adding.add(howMany);

        cost.addActionListener(this);
        name.addActionListener(this);
        howMany.addActionListener(this);

        cost.setVisible(true);
        name.setVisible(false);
        howMany.setVisible(false);

        finding.setBackground(Color.YELLOW);
        finding.setSize(300,300);
        finding.setLayout(new FlowLayout());
        finding.add(findWhat);
        findWhat.addActionListener(this);

        removing.setBackground(Color.RED);
        removing.setSize(300,300);
        removing.setLayout(new FlowLayout());
        removing.add(removeWhat);
        removeWhat.addActionListener(this);

        controlPanel.add(choosing);
        controlPanel.add(adding);
        controlPanel.add(finding);
        controlPanel.add(removing);

        //Add and prep the essentials
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(msg);
        mainFrame.setVisible(true);
        choosing.setVisible(false);
        adding.setVisible(false);
        finding.setVisible(false);
        removing.setVisible(false);
        msg.setVisible(false);
        //SHOP
        itemAmounting();
    }

    //Choose how many items you're getting
    public void itemAmounting(){
        headerLabel.setText("Welcome to our Shopping List Application! How big will your cart be?");

        amount = new Panel();
        amount.setBackground(Color.YELLOW);
        amount.setSize(300,300);
        amount.setLayout(new FlowLayout());
        amount.add(totalItems);
        totalItems.addActionListener(this);

        controlPanel.add(amount);
        mainFrame.setVisible(true);
    }

    //Buttons and stuff for choosing your options on what your doing
    public void chooseOption(){
        amount.setVisible(false);
        headerLabel.setText("What option do you wish to choose? Add an item, remove an item, or check if you have an item?");

        choosing.setVisible(true);
        mainFrame.setVisible(true);
    }

    //Add things
    public void addItem(){
        choosing.setVisible(false);
        headerLabel.setText("How much is the item you are adding?");

        cost.setVisible(true);
        name.setVisible(false);
        howMany.setVisible(false);

        adding.setVisible(true);
        mainFrame.setVisible(true);
    }

    //Find things
    public void findItem(){
        choosing.setVisible(false);
        headerLabel.setText("What item would you like to see?");

        finding.setVisible(true);
        mainFrame.setVisible(true);
    }

    //Remove things
    public void removeItem(){
        choosing.setVisible(false);
        headerLabel.setText("What item would you like to remove?");

        removing.setVisible(true);
        mainFrame.setVisible(true);
    }

    //ACTION LISTENERS AAAAAAA
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == totalItems){
            orders = Integer.parseInt(totalItems.getText());
            chooseOption();
        }
        else if (e.getSource() == cost){
            itemCost = Double.parseDouble(cost.getText());
            headerLabel.setText("What is the name of the item?");
            cost.setText("");
            cost.setVisible(false);
            name.setVisible(true);
            mainFrame.setSize(651,250); //refresh
        }
        else if (e.getSource() == name){
            thing = new Item(itemCost, name.getText());
            headerLabel.setText("How many of that item are you buying?");
            name.setText("");
            name.setVisible(false);
            howMany.setVisible(true);
            mainFrame.setSize(650, 250); //refresh
        }
        else if (e.getSource() == howMany){
            list.add(new ItemOrder(thing, Integer.parseInt(howMany.getText())));
            howMany.setText("");
            adding.setVisible(false);
            chooseOption();
            currentItemTotal += 1;
        }
        else if (e.getSource() == findWhat){
            //Search for item, print out whether or not it is found
            boolean found = false;
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).getItem().getItemName().equals(findWhat.getText())){
                    found = true;
                }
            }
            if (found){
                System.out.println("The item " + findWhat.getText() + " is present");
                finding.setVisible(false);
                findWhat.setText("");
                chooseOption();
            }
            else {
                System.out.println("The item " + findWhat.getText() + " is not present");
                findWhat.setText("");
                finding.setVisible(false);
                chooseOption();
            }
        }
        else if (e.getSource() == removeWhat){
            //Search for item, remove it if it is found, print out whether or not it is removed
            boolean found = false;
            int forLater = 0;
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).getItem().getItemName().equals(removeWhat.getText())){
                    found = true;
                    forLater = i;
                }
            }
            if (found){
                System.out.println("The item " + removeWhat.getText() + " has been removed");
                list.remove(list.get(forLater));
                removing.setVisible(false);
                removeWhat.setText("");
                chooseOption();
                currentItemTotal -= 1;
            }
            else {
                System.out.println("The item " + removeWhat.getText() + " is not present and therefore cannot be removed");
                removeWhat.setText("");
                removing.setVisible(false);
                chooseOption();
            }
        }
        else if (e.getSource() == add){
            addItem();
        }
        else if (e.getSource() == search){
            findItem();
        }
        else if (e.getSource() == remove){
            removeItem();
        }

        //Once the cart is full, the program immediately executes this end code, closing out everything else, and printing out the price of your cart
        if (currentItemTotal == orders){
            headerLabel.setVisible(false);
            msg.setVisible(true);
            controlPanel.setVisible(false);
            double totalPrice = 0.00;
            for (int i = 0; i < list.size(); i++){
                System.out.println(list.get(i).getHowMany() + " " + list.get(i).getItem().getItemName() + "(s) for $" + (list.get(i).getItem().getPrice() * list.get(i).getHowMany()));
                totalPrice += (list.get(i).getItem().getPrice() * list.get(i).getHowMany());
            }
            System.out.println("The total price of your list is: $" + totalPrice);
        }
    }
}
