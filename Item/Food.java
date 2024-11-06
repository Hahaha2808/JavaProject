package Item;

public class Food extends Item {
    // Attribute specific to Food
    private boolean isSpicy;
    
    // Constructor 
    public Food (int itemID, String name, String description, float price, boolean availability, boolean isSpicy) {
        super(itemID, name, description, price, availability);
        this.isSpicy = isSpicy;
    }
    
    // Setter for spicy status
    public void setSpicy(boolean isSpicy) {
        this.isSpicy = isSpicy;
    }
    
    // Getter for spicy status
    public boolean getSpicy() {
        return isSpicy;
    }
    
    // Override getItemInfo to include spice level
    @Override
    public String getItemInfo() {
        return super.getItemInfo() + "\nSpicy: " + (isSpicy ? "Yes" : "No");
    }
    
}