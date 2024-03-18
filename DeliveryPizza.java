import java.util.ArrayList;

public class DeliveryPizza extends Pizza{
    private int deliveryFee;
    private String deliveryLocation;

    public DeliveryPizza(ArrayList<String> toppings, int toppingAmount, String deliveryLocation){ //Constructor
        super(toppings, toppingAmount);
        this.deliveryLocation = deliveryLocation;
        if (getPrice() > 18){
            this.deliveryFee = 3;
        }
        else {
            this.deliveryFee = 5;
        }
    }

    public int getDeliveryFee() { //Getter for delivery fee
        return deliveryFee;
    }

    public String getDeliveryLocation() { //Getter for delivery location
        return deliveryLocation;
    }

    @Override
    public String toString() { //Override the toString
        return "Your delivery has the toppings of: " + super.toString() + ", with a delivery fee of: $" + deliveryFee + " and is delivering to: " + deliveryLocation;
    }
}
