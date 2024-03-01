public class Person {
    //So what's their name?
    private String firstName;
    private String lastName;

    //Constructor for person object
    public Person(String first, String last){
        firstName = first;
        lastName = last;
    }

    public String getFirstName() { //firstName getter
        return firstName;
    }

    public String getLastName() { //lastName getter
        return lastName;
    }
}
