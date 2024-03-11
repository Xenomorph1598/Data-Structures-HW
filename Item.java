public class Item {
    private double price;
    private String itemName;

    public Item(double itemPrice, String name){ //Constructor
        this.itemName = name;
        this.price = itemPrice;
    }

    public double getPrice() {
        return price;
    } //Getter for price

    public String getItemName() {
        return itemName;
    } //Getter for ItemName
}
