public class Party {
    private int guests; //Integer for how many guests there are
    private String supplies;

    public void setGuests(int guests) { //Setter for guests integer
        this.guests = guests;
    }

    public int getGuests() { //Getter for guests integer
        return guests;
    }

    public void setSupplies(String supplies) {
        this.supplies = supplies;
    }

    public String getSupplies() {
        return supplies;
    }

    public void displayInvitation(){ //Prints the invitation text out
        System.out.println("Please come to our wedding!");
    }
}
