import java.util.ArrayList;

public class Pizza {
    private ArrayList<String> toppings;
    private int toppingAmount;
    private int price;
    private String description;

    public Pizza(ArrayList<String> toppings, int toppingAmount){ //Constructor
        this.toppings = toppings;
        this.toppingAmount = toppingAmount;
        this.price = 14 + (2 * toppings.size());
        this.description = "";
        for (int i = 0; i < toppings.size(); i++){
            description += toppings.get(i) + ", ";
        }
        description = description.substring(0, description.length() - 2);
    }

    public ArrayList<String> getToppings() { //Getter for toppings
        return toppings;
    }

    public int getToppingAmount() { //Getter for toppings amount
        return toppingAmount;
    }

    public int getPrice() { //Getter for price
        return price;
    }

    @Override
    public String toString() { //Overrides the toString
        return "Your order has the toppings: " + description + " and costs: $" + price;
    }
}
