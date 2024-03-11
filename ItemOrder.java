public class ItemOrder {
    private Item item;
    private int howMany;

    public ItemOrder(Item theThing, int muchOf){ //Constructor
        this.item = theThing;
        this.howMany = muchOf;
    }

    public Item getItem() { //Getter for Item
        return item;
    }

    public int getHowMany() { //Getter for howMany
        return howMany;
    }
}
