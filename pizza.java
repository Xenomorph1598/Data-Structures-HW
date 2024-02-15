import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pizza extends JFrame implements ActionListener, ItemListener{
    private Frame mainFrame; //This is the frame everything happens on
    private Label headerLabel; //This is the main label that is above everything
    private TextField orderCost; //This textfield shows the price of your order
    private Panel controlPanel; //This is the main panel on the frame
    private Panel sizes; //This panel contains the buttons for selecting a size
    private Panel toppings; //This panel contains checkBoxes for selecting your toppings
    private JLabel thanks; //This label just pops up to say thank you

    //These four buttons are for selecting pizza sizes
    private JButton btnSmall = new JButton("Small");
    private JButton btnMedium = new JButton("Medium");
    private JButton btnLarge = new JButton("Large");
    private JButton btnSuper = new JButton("Super");

    //This checkBox allows for an early quit out of the toppings selection
    private JCheckBox toppingsChosen = new JCheckBox("Done selecting");

    //These 10 checkBoxes are for selecting your toppings
    private JCheckBox moarCHEESE = new JCheckBox("Extra Cheese");
    private JCheckBox pepperoni = new JCheckBox("Pepperoni");
    private JCheckBox sausage = new JCheckBox("Sausage");
    private JCheckBox ham = new JCheckBox("Ham");
    private JCheckBox olives = new JCheckBox("Olives");
    private JCheckBox mushrooms = new JCheckBox("Mushrooms");
    private JCheckBox onions = new JCheckBox("Onions");
    private JCheckBox peppers = new JCheckBox("Peppers");
    private JCheckBox spinach = new JCheckBox("Spinach");
    private JCheckBox pineapple = new JCheckBox("Pineapple");
    private double cost = 0.00; //This guy just holds the current price
    private int totalToppings = 0; //This stores how many toppings are currently selected so the program totals them properly

    //The constructor for a pizza object that just does the rest of the code when you make a pizza object
    public pizza(){
        prepareGUI();
    }

    //Oh boy main method that makes a pizza object and starts running it
    public static void main(String[] args){
        pizza bigY = new pizza();
        bigY.showSizes();
    }

    //This method creates the main Frame and GUI for all the fun stuff to work and show up on
    private void prepareGUI(){
        //CREATE THE MAINFRAME
        mainFrame = new Frame("BigY Pizza Application");
        mainFrame.setSize(650,250);
        mainFrame.setBackground(Color.red); //MAKE IT RED BECAUSE SAUCE
        mainFrame.setLayout(new FlowLayout());

        //Makes the program end on window close
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        //The price box and the main label
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        orderCost = new TextField("$0.00");
        orderCost.setEditable(false);

        //This literally just tells you "THANK YOU" before you close the program
        thanks = new JLabel();
        thanks.setAlignmentX(Label.CENTER);
        thanks.setText("Thank you for your order!");

        //Main panel that contains all the cool fun things
        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(orderCost);
        mainFrame.add(thanks);
        thanks.setVisible(false);
        mainFrame.setVisible(true);
    }

    //Method for showing the sizes of the pizza, allows
    private void showSizes(){
        headerLabel.setText("Welcome to the BigY Store Pizza Application! What size Pizza do you want?");

        sizes = new Panel();
        sizes.setBackground(Color.YELLOW);
        sizes.setSize(300,300);
        GridLayout layout = new GridLayout(0,4);
        layout.setHgap(10);
        layout.setVgap(10);
        sizes.setLayout(layout);
        sizes.add(btnSmall);
        sizes.add(btnMedium);
        sizes.add(btnLarge);
        sizes.add(btnSuper);
        btnSmall.addActionListener(this);
        btnMedium.addActionListener(this);
        btnLarge.addActionListener(this);
        btnSuper.addActionListener(this);

        controlPanel.add(sizes);
        mainFrame.setVisible(true);
    }

    //Method for the toppings. Extremely similar to showSizes, since both work off grids
    public void showToppings(){
        headerLabel.setText("Now what toppings would you like (MAX 3) (EXTRA CHEESE DOES NOT COUNT)?");
        sizes.setVisible(false);

        toppings = new Panel();
        toppings.setBackground(Color.YELLOW);
        toppings.setSize(300,300);
        GridLayout layout = new GridLayout(0,5);
        layout.setHgap(10);
        layout.setVgap(10);
        toppings.setLayout(layout);
        toppings.add(moarCHEESE);
        toppings.add(pepperoni);
        toppings.add(sausage);
        toppings.add(ham);
        toppings.add(olives);
        toppings.add(mushrooms);
        toppings.add(onions);
        toppings.add(peppers);
        toppings.add(spinach);
        toppings.add(pineapple);
        toppings.add(toppingsChosen);

        //Adds ItemListeners to the CheckBox Toppings
        pepperoni.addItemListener(this);
        sausage.addItemListener(this);
        ham.addItemListener(this);
        olives.addItemListener(this);
        mushrooms.addItemListener(this);
        onions.addItemListener(this);
        peppers.addItemListener(this);
        spinach.addItemListener(this);
        pineapple.addItemListener(this);
        toppingsChosen.addItemListener(this);

        controlPanel.add(toppings);
        mainFrame.setVisible(true);
    }

    //ActionListener method... thing... whatever it makes the ActionListeners work for selecting the sizes
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnSmall){
            cost += 5.00;
            orderCost.setText("$" + cost);
            showToppings();
        }
        else if (e.getSource() == btnMedium){
            cost += 10.00;
            orderCost.setText("$" + cost);
            showToppings();
        }
        else if (e.getSource() == btnLarge){
            cost += 15.00;
            orderCost.setText("$" + cost);
            showToppings();
        }
        else if (e.getSource() == btnSuper){
            cost += 20.00;
            orderCost.setText("$" + cost);
            showToppings();
        }
    }

    //Method for ItemListeners to work
    @Override
    public void itemStateChanged(ItemEvent i){
        //Using pepperoni as an example, everytime the object's state changes, if it is active it adds fifty cents and if
        //it is inactive it removes fifty cents, doing the same for if it is included in the total topping count
        if (i.getSource() == pepperoni){
            if (pepperoni.isSelected()){
                cost += 0.50;
                orderCost.setText("$" + cost);
                totalToppings += 1;
            }
            else {
                cost -= 0.50;
                orderCost.setText("$" + cost);
                totalToppings -= 1;
            }
        }
        else if (i.getSource() == sausage){
            if (sausage.isSelected()){
                cost += 0.50;
                orderCost.setText("$" + cost);
                totalToppings += 1;
            }
            else {
                cost -= 0.50;
                orderCost.setText("$" + cost);
                totalToppings -= 1;
            }
        }
        else if (i.getSource() == ham){
            if (ham.isSelected()){
                cost += 0.50;
                orderCost.setText("$" + cost);
                totalToppings += 1;
            }
            else {
                cost -= 0.50;
                orderCost.setText("$" + cost);
                totalToppings -= 1;
            }
        }
        else if (i.getSource() == olives){
            if (olives.isSelected()){
                cost += 0.50;
                orderCost.setText("$" + cost);
                totalToppings += 1;
            }
            else {
                cost -= 0.50;
                orderCost.setText("$" + cost);
                totalToppings -= 1;
            }
        }
        else if (i.getSource() == mushrooms){
            if (mushrooms.isSelected()){
                cost += 0.50;
                orderCost.setText("$" + cost);
                totalToppings += 1;
            }
            else {
                cost -= 0.50;
                orderCost.setText("$" + cost);
                totalToppings -= 1;
            }
        }
        else if (i.getSource() == onions){
            if (onions.isSelected()){
                cost += 0.50;
                orderCost.setText("$" + cost);
                totalToppings += 1;
            }
            else {
                cost -= 0.50;
                orderCost.setText("$" + cost);
                totalToppings -= 1;
            }
        }
        else if (i.getSource() == peppers){
            if (peppers.isSelected()){
                cost += 0.50;
                orderCost.setText("$" + cost);
                totalToppings += 1;
            }
            else {
                cost -= 0.50;
                orderCost.setText("$" + cost);
                totalToppings -= 1;
            }
        }
        else if (i.getSource() == spinach){
            if (spinach.isSelected()){
                cost += 0.50;
                orderCost.setText("$" + cost);
                totalToppings += 1;
            }
            else {
                cost -= 0.50;
                orderCost.setText("$" + cost);
                totalToppings -= 1;
            }
        }
        else if (i.getSource() == pineapple){
            if (pineapple.isSelected()){
                cost += 0.50;
                orderCost.setText("$" + cost);
                totalToppings += 1;
            }
            else {
                cost -= 0.50;
                orderCost.setText("$" + cost);
                totalToppings -= 1;
            }
        }
        //The done selecting checkBox adds .25 to the cost, then sets totalToppings to three, allowing an early quit out
        //and canceling out the -.25 of the end code
        else if (i.getSource() == toppingsChosen){
            cost += .25;
            totalToppings += (3 - totalToppings);
        }

        if (totalToppings == 3){
            thanks.setVisible(true);
            toppings.setVisible(false);
            headerLabel.setVisible(false);
            cost -= .25;
            orderCost.setText("$" + cost);
        }
    }
}