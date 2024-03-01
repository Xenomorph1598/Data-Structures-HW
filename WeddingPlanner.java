import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

public class WeddingPlanner extends JFrame implements ActionListener{
    //These are all the objects and generic variables needed
    private Person personOne;
    private Person personTwo;
    private Couple marrying;
    private LocalDate weddingDay;
    private String place;
    private Wedding wedding;
    private Frame mainFrame; //This is the frame everything happens on
    private Label headerLabel; //This is the main label that is above everything
    private Label msg; //End message like PartyPlanner
    private TextField firstPerson; //Textfield to enter the name of the first person who's getting married
    private TextField secondPerson; //Textfield to enter the name of the second person who's getting married
    private TextField date; //Textfield to enter the date
    private TextField location; //Textfield to enter location
    private Panel controlPanel; //Main panel for everything happening to happen on
    private Panel whosMarrying; //Panel for entering personOne and personTwo for the couple object

    //Constructor for a TestWedding. Just runs the main GUI
    public WeddingPlanner(){
        mainPlanner();
    }

    public static void main(String[] args){
        WeddingPlanner planMe = new WeddingPlanner();
    }

    private void mainPlanner(){
        //CREATE THE MAINFRAME, AS USUAL
        mainFrame = new Frame("Wedding Planner application");
        mainFrame.setSize(650,250);
        mainFrame.setBackground(Color.white); //White because what other colors are weddings usually
        mainFrame.setLayout(new FlowLayout());

        //Now on close it opens up a PartyPlanner to make your Wedding Reception!
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                PartyPlanner weddingReception = new PartyPlanner();
            }
        });

        //The main label, where you enter numbers and the msg label
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        msg = new Label("Your wedding details are ready in the console! You can close this window to proceed on to the reception planning.");
        firstPerson = new TextField();
        secondPerson = new TextField();
        date = new TextField();
        location = new TextField();

        //Main panel that contains all the cool fun things
        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        //Add and prep the essentials
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(msg);
        mainFrame.setVisible(true);
        controlPanel.setVisible(true);
        msg.setVisible(false);
        //Begin the wedding preparations
        whosMarrying();
    }

    public void whosMarrying(){
        headerLabel.setText("Who's the first person getting married? (Enter as first name space last name)");

        whosMarrying = new Panel();
        whosMarrying.setBackground(Color.pink); //Red because love
        whosMarrying.setSize(300,300);
        whosMarrying.setLayout(new FlowLayout());

        //Put in the textFields
        firstPerson.setVisible(true);
        firstPerson.addActionListener(this);
        secondPerson.setVisible(false);
        secondPerson.addActionListener(this);
        date.setVisible(false);
        date.addActionListener(this);
        location.setVisible(false);
        location.addActionListener(this);

        whosMarrying.add(firstPerson);
        whosMarrying.add(secondPerson);
        whosMarrying.add(date);
        whosMarrying.add(location);

        controlPanel.add(whosMarrying);
        mainFrame.setSize(651, 250); //Look. Refreshers are back YAAAAAY
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == firstPerson){
            //Takes the text and splits it up so it can create a person object with the name
            String first = firstPerson.getText();
            String[]firstFull = first.split(" ");
            personOne = new Person(firstFull[0], firstFull[1]);
            //Set up next person
            firstPerson.setVisible(false);
            secondPerson.setVisible(true);
            headerLabel.setText("Who's the second person getting married? (Enter as first name space last name)");
            mainFrame.setSize(650, 250);

        }
        else if (e.getSource() == secondPerson){
            //Same as above
            String second = secondPerson.getText();
            String[]secondFull = second.split(" ");
            personTwo = new Person(secondFull[0], secondFull[1]);
            marrying = new Couple(personOne, personTwo); //Create couple object
            //Set up for date
            headerLabel.setText("Enter date (year-month-day):");
            secondPerson.setVisible(false);
            date.setVisible(true);
            mainFrame.setSize(651, 250);
        }
        else if (e.getSource() == date){
            //Takes the string and turns them to ints to make a LocalDate with
            String dateString = date.getText();
            String[] turnToInts = dateString.split("-");
            weddingDay = LocalDate.of((int) (Integer.parseInt(turnToInts[0])), (int) (Integer.parseInt(turnToInts[1])), (int) (Integer.parseInt(turnToInts[2])));
            //Set up for location
            headerLabel.setText("Now enter location:");
            date.setVisible(false);
            location.setVisible(true);
            mainFrame.setSize(650, 250);
        }
        else if (e.getSource() == location){
            //Finally, just take what's written in location for place, and make the wedding object, and print it out, and print msg
            place = location.getText();
            wedding = new Wedding(marrying, weddingDay, place);
            System.out.println("Wedding details are:");
            System.out.println("Marrying is " + wedding.getToBeMarried().getPersonOne().getFirstName() + " " + wedding.getToBeMarried().getPersonOne().getLastName() + " and " + wedding.getToBeMarried().getPersonTwo().getFirstName() + " " + wedding.getToBeMarried().getPersonTwo().getLastName());
            System.out.println("On " + wedding.getWeddingDay().toString());
            System.out.println("At " + wedding.getLocation());
            location.setVisible(false);
            msg.setVisible(true);
        }
    }
}
