package Item;

public class Drink extends Item {
    // Attribute specific to Drink
    private boolean isAlcoholic;
    
    // Constructor
    public Drink(int itemID, String name, String description, float price, boolean availability, boolean isAlcoholic) {
        super(itemID, name, description, price, availability);
        this.isAlcoholic = isAlcoholic;
    }
    
    // Setter for alcoholic status
    public void setAlcoholic(boolean isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }
    
    // Getter for alcoholic status
    public boolean isAlcoholic() {
        return isAlcoholic;
    }
    
    // Override getItemInfo to include alcoholic info
    @Override 
    public String getItemInfo() {
        return super.getItemInfo() + "\nAlcoholic: " + (isAlcoholic ? "Yes" : "No");
    }
}