import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DemoPizza extends JFrame implements ActionListener {
    //General variables
    private ArrayList<String> toppings = new ArrayList<>();
    private int howManyToppings = 0;
    private Frame mainFrame; //This is the frame everything happens on
    private Label headerLabel; //This is the main label that is above everything
    private TextField enterTopping; //This textfield is for entering in a topping
    private TextField enterLocation; //This textfield is for entering the location of where to deliver a pizza
    private Panel controlPanel; //This is the main panel on the frame
    private Panel toppingsHere; //This panel is for choosing toppings
    private Panel howToGetPizza; //This panel contains the buttons for selecting how to get your pizza
    private Panel delivery; //This alternative panel is for making a delivery
    private JLabel msg; //This label just pops up to say thank you

    //These buttons are for selecting whether your pizza is for here or for delivery
    private JButton btnHere = new JButton("For Here");
    private JButton btnDelivery = new JButton("For Delivery");

    //The works of the constructor
    public DemoPizza(){
        prepareGUI();
    }

    //Main does what they usually do
    public static void main(String[] args){
        DemoPizza pizzaTime = new DemoPizza();
    }

    //Main GUI
    private void prepareGUI(){
        //CREATE THE MAINFRAME
        mainFrame = new Frame("Pizza Application");
        mainFrame.setSize(650,250);
        mainFrame.setBackground(Color.red); //MAKE IT RED BECAUSE SAUCE
        mainFrame.setLayout(new FlowLayout());

        //Makes the program end on window close
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        //The main label
        headerLabel = new Label("Welcome to our pizza application! What toppings do you want?");
        headerLabel.setAlignment(Label.CENTER);

        //This literally just tells you "THANK YOU" before you close the program
        msg = new JLabel();
        msg.setAlignmentX(Label.CENTER);
        msg.setText("Thank you for your order! It is in the console.");

        //Main panel that contains all the cool fun things
        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(msg);
        msg.setVisible(false);
        mainFrame.setVisible(true);
        //BEGIN
        toppingTime();
    }

    //Adding in toppings
    public void toppingTime(){
        toppingsHere = new Panel();
        toppingsHere.setBackground(Color.YELLOW);
        toppingsHere.setSize(300,300);
        toppingsHere.setLayout(new FlowLayout());

        enterTopping = new TextField();
        enterTopping.addActionListener(this);
        toppingsHere.add(enterTopping);

        controlPanel.add(toppingsHere);
        mainFrame.setVisible(true);
    }

    //Heres to selecting whether its delivery or digiorno
    public void deliveryOrHere(){
        controlPanel.remove(toppingsHere);
        headerLabel.setText("How do you want to get that pizza?");

        howToGetPizza = new Panel();
        howToGetPizza.setBackground(Color.YELLOW);
        howToGetPizza.setSize(300,300);
        GridLayout layout = new GridLayout(0,2);
        layout.setHgap(10);
        layout.setVgap(10);
        howToGetPizza.setLayout(layout);
        howToGetPizza.add(btnHere);
        howToGetPizza.add(btnDelivery);

        btnHere.addActionListener(this);
        btnDelivery.addActionListener(this);

        controlPanel.add(howToGetPizza);
        mainFrame.setVisible(true);
    }

    //Its delivery
    public void deliverMe(){
        controlPanel.remove(howToGetPizza);
        headerLabel.setText("Where are we delivering to?");

        delivery = new Panel();
        delivery.setBackground(Color.YELLOW);
        delivery.setSize(300,300);
        delivery.setLayout(new FlowLayout());

        enterLocation = new TextField();
        enterLocation.addActionListener(this);
        delivery.add(enterLocation);

        controlPanel.add(delivery);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == enterTopping){
            //Checks if you entered QUIT and does appropriately, or also checks if you have 10 toppings
            if (enterTopping.getText().equals("QUIT")){
                deliveryOrHere();
            }
            else{
                toppings.add(enterTopping.getText());
                howManyToppings += 1;
                enterTopping.setText("");
            }

            if (howManyToppings == 10){
                deliveryOrHere();
            }
        }
        else if (e.getSource() == enterLocation){ //Prints out a delivery pizza object if you choose "delivery"
            controlPanel.setVisible(false);
            headerLabel.setVisible(false);
            msg.setVisible(true);
            DeliveryPizza there = new DeliveryPizza(toppings, howManyToppings, enterLocation.getText());
            System.out.println(there);
        }
        else if (e.getSource() == btnHere){ //Prints out a normal pizza object if you choose "here"
            controlPanel.setVisible(false);
            headerLabel.setVisible(false);
            msg.setVisible(true);
            Pizza here = new Pizza(toppings, howManyToppings);
            System.out.println(here);
        }
        else if (e.getSource() == btnDelivery){ //Just sets up for delivery
            deliverMe();
        }
    }
}
