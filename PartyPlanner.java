import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PartyPlanner extends JFrame implements ActionListener{ //This class has the gui and ability to run the party classes
    private Party woo = new Party(); //Party object for everywhere use
    private DinnerParty delicious = new DinnerParty(); //DinnerParty object for everywhere use
    private int guests; //For taking in the guest count when entered
    private Frame mainFrame; //This is the frame everything happens on
    private Label headerLabel; //This is the main label that is above everything
    private Label msg; //This panel just tells you your invitation is printed
    private TextField enterGuestsReg; //This textfield is for you to enter in the guest count for a regular party
    private TextField enterSuppliesReg; //This textfield is for you to enter in the supplies needed for a regular party
    private TextField enterGuestsDin; //This textfield is for entering the guests of a dinner party
    private TextField enterSuppliesDin; //This textfield is for enterin the supplies needed for a dinner party
    private TextField enterDinChoice; //This textfield is for entering the dinner choice of a dinner party
    private Panel controlPanel; //Main panel for everything happening to happen on
    private Panel partyChoice; //This panel is for choosing your party
    private Panel regularParty; //This panel is for planning a regular party
    private Panel dinnerParty; //This panel is for planning a regular party
    private JButton regParty = new JButton("Normal Reception"); //This button chooses opening up the selections for a normal party
    private JButton dinParty = new JButton("Dinner Reception"); //This button chooses opening up the selections for a dinner party

    //Constructor for a PartyPlanner object, just runs the main planner frame... part of the GUI
    public PartyPlanner(){
        mainPlanner();
    }

    //The main method creates a PartyPlanner object so everything begins
    public static void main(String[] args){
        PartyPlanner partyTime = new PartyPlanner();
    }

    //This is the main window where everything occurs on
    private void mainPlanner(){
        //CREATE THE MAINFRAME, AS USUAL
        mainFrame = new Frame("Reception Planner application");
        mainFrame.setSize(650,250);
        mainFrame.setBackground(Color.green); //Green because... I like green there's not really a good color for this
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
        msg = new Label("Your planned reception is ready in the console!");
        enterGuestsReg = new TextField();
        enterSuppliesReg = new TextField();
        enterGuestsDin = new TextField();
        enterSuppliesDin = new TextField();
        enterDinChoice = new TextField();

        //Main panel that contains all the cool fun things
        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        //Add and prep the essentials
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(msg);
        mainFrame.setVisible(true);
        msg.setVisible(false);
        //Begin the choosing
        chooseParty();
    }

    //This method is for choosing what type of party you are planning
    public void chooseParty(){
        headerLabel.setText("Thank you for choosing our Reception Planner! What type of Reception are you planning?");

        //Create panel
        partyChoice = new Panel();
        partyChoice.setBackground(Color.blue); //Blue because... why do I keep trying to explain why
        partyChoice.setSize(300,300);
        partyChoice.setLayout(new FlowLayout());

        //Add the buttons and get them set up and ready to choose
        partyChoice.add(regParty);
        partyChoice.add(dinParty);
        regParty.addActionListener(this);
        dinParty.addActionListener(this);

        controlPanel.add(partyChoice);
        mainFrame.setVisible(true);
    }

    //This method is for planning out a regular, baseline party
    public void showRegPartyPlanner(){
        headerLabel.setText("Planning a Regular Reception! How many guests are coming? Enter here:");
        partyChoice.setVisible(false);

        regularParty = new Panel();
        regularParty.setBackground(Color.red); //Red because why not
        regularParty.setSize(300,300);
        regularParty.setLayout(new FlowLayout());

        //Make sure the textfields are properly set up
        enterGuestsReg.setVisible(true);
        enterGuestsReg.addActionListener(this);
        enterSuppliesReg.setVisible(false);
        enterSuppliesReg.addActionListener(this);

        //Add them
        regularParty.add(enterGuestsReg);
        regularParty.add(enterSuppliesReg);

        controlPanel.add(regularParty);
        mainFrame.setSize(651, 250); //Refresher, explained later
    }

    //This method is for setting up a Dinner Party plan
    public void showDinPartyPlanner(){
        headerLabel.setText("Planning a Dinner Reception! How many guests are coming? Enter here:");
        partyChoice.setVisible(false);

        dinnerParty = new Panel();
        dinnerParty.setBackground(Color.yellow); //Yellow because it's the final primary color
        dinnerParty.setSize(300,300);
        dinnerParty.setLayout(new FlowLayout());

        //Make sure the textfields are properly set up
        enterGuestsDin.setVisible(true);
        enterGuestsDin.addActionListener(this);
        enterSuppliesDin.setVisible(false);
        enterSuppliesDin.addActionListener(this);
        enterDinChoice.setVisible(false);
        enterDinChoice.addActionListener(this);

        //Add them
        dinnerParty.add(enterGuestsDin);
        dinnerParty.add(enterSuppliesDin);
        dinnerParty.add(enterDinChoice);

        controlPanel.add(dinnerParty);
        mainFrame.setSize(651, 250);
    }

    //Action listeners now work because of this
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == regParty){
            showRegPartyPlanner();
        }
        else if (e.getSource() == dinParty){
            showDinPartyPlanner();
        }
        else if (e.getSource() == enterGuestsReg){
            guests = (int) (Integer.parseInt(enterGuestsReg.getText()));
            woo.setGuests(guests); //Sets the guests to what you entered
            headerLabel.setText("Now what supplies do you need? Enter here:");
            //Switches the textfields out since they have different code for when activated
            enterGuestsReg.setVisible(false);
            enterSuppliesReg.setVisible(true);
            //Now this might seem completely useless, but it actually causes the enterSuppliesReg textfield to appear by
            //giving the window a little refresh by making it 1 pixel wider
            mainFrame.setSize(650,250);
        }
        else if (e.getSource() == enterSuppliesReg){
            woo.setSupplies(enterSuppliesReg.getText());
            //Cleans up the window, and prints out the information of the party in the console
            controlPanel.setVisible(false);
            headerLabel.setVisible(false);
            msg.setVisible(true);
            System.out.println("The reception has " + woo.getGuests() + " guests");
            System.out.println("The needed supplies are: " + woo.getSupplies());
            System.out.println("Your invitation is:");
            woo.displayInvitation();
        }
        else if (e.getSource() == enterGuestsDin){
            //The execution of this is the exact same as enterGuestsReg, just it affects the DinnerParty items instead
            guests = (int) (Integer.parseInt(enterGuestsDin.getText()));
            delicious.setGuests(guests);
            headerLabel.setText("Now what supplies do you need? Enter here:");
            enterGuestsDin.setVisible(false);
            enterSuppliesDin.setVisible(true);
            mainFrame.setSize(650,250);
        }
        else if (e.getSource() == enterSuppliesDin){
            //The only difference here is that now, it sets up for you to enter your dinner choice
            delicious.setSupplies(enterSuppliesDin.getText());
            headerLabel.setText("What is the dinner choice? 1 for Chicken, 2 for Steak, 3 for Pork, 4 for Seafood, 5 for Veggies. Enter here:");
            enterSuppliesDin.setVisible(false);
            enterDinChoice.setVisible(true);
            mainFrame.setSize(651,250); //Another reset
        }
        else if (e.getSource() == enterDinChoice){
            //Now, it does the same to finish up and display the finalized plan, just with the addition of the dinner choice
            delicious.setDinnerChoice((int) (Integer.parseInt(enterDinChoice.getText())));
            controlPanel.setVisible(false);
            headerLabel.setVisible(false);
            msg.setVisible(true);
            System.out.println("The dinner reception has " + delicious.getGuests() + " guests");
            System.out.println("The needed supplies are: " + delicious.getSupplies());
            System.out.println("The dinner choice is menu item " + delicious.getDinnerChoice());
            System.out.println("Your invitation is:");
            delicious.displayInvitation();
        }
    }
}
