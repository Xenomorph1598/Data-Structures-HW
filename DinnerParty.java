public class DinnerParty extends Party{ //This party has the addition of dinner, so it inherits everything else and adds the dinnerChoice variable
    private int dinnerChoice; //WHAT DINNER WILL YOU BE HAVING

    public int getDinnerChoice() { //Getter for dinner choice
        return dinnerChoice;
    }

    public void setDinnerChoice(int dinnerChoice) { //Setter for dinner choice
        this.dinnerChoice = dinnerChoice;
    }
}
