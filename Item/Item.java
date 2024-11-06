package Item;

public class Item {
    // Attributes
    private int itemID;
    private String name;
    private String description;
    private float price;
    private boolean availability;
    
    // Constructor
    public Item(int itemID, String name, String description, float price, boolean availability) {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.availability = availability;
    }
    
    // Setter for item name
    public void setName(String name) {
        this.name = name;
    }
    
    // Setter for item price
    public void setPrice(float price) {
        this.price = price;
    }
    
    // Setter for item description
    public void setDescription(String description) {
        this.description = description;
    }
    
    // Setter for item availability
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    
    // Getter for item info
    public String getItemInfo() {
        return "Item ID: " + itemID + "\n" + 
                "Name: " + name + "\n" + 
                "Description: " + description + "\n" +
                "Price: $" + price + "\n" +
                "Availability: " + (availability ? "Yes" : "No");
    }

    // Getter methods for each field if individual access is required
    public int getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return availability;
    }
}

