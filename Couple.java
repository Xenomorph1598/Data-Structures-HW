import javax.swing.*;

public class Couple {
    //Who are the two people in the couple
    private Person personOne;
    private Person personTwo;

    //Constructor for a couple object
    public Couple(Person one, Person two){
        personOne = new Person(one.getFirstName(), one.getLastName());
        personTwo = new Person(two.getFirstName(), two.getLastName());
    }

    public Person getPersonOne() { //Getter for personOne
        return personOne;
    }

    public Person getPersonTwo() { //Getter for personTwo
        return personTwo;
    }
}
