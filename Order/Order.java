package Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Item.Item;

public class Order {
    // Attributes
    private int orderID;
    private String customerName;
    private String phoneNo;
    private List<Item> orderItems;
    private Date orderDate;
    private boolean orderStatus; // true = finished, false = open
    
    // Constructor
    public Order(int orderID, String customerName, String phoneNo, Date orderDate) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.phoneNo = phoneNo;
        this.orderItems = new ArrayList<>();
        this.orderDate = orderDate;
        this.orderStatus = false; // Order is open by default
    }
    
    // Setters
    public void setName(String customerName) {
        this.customerName = customerName;
    }
    
    public void setPhone(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public void setStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    // Item management methods
    public void insertItem(Item item) {
        if (item.isAvailable()) {
            orderItems.add(item);
            System.out.println("Item added: " + item.getName());
        } else {
            System.out.println("Item not available: " + item.getName() + " (Out of stock)");
        }
    }
    
    public void removeItem(int itemID) {
        boolean removed = orderItems.removeIf(item -> item.getItemID() == itemID);
        if (removed) {
            System.out.println("Item with ID " + itemID + " has been removed from the order.");
        } else {
            System.out.println("Item with ID " + itemID + " not found in the order.");
        }
    }
    
    // Method to retrieve order info
    public String viewOrder() {
        StringBuilder orderInfo = new StringBuilder();
        orderInfo.append("Order ID: ").append(orderID).append("\n");
        orderInfo.append("Customer Name: ").append(customerName).append("\n");
        orderInfo.append("Phone No: ").append(phoneNo).append("\n");
        orderInfo.append("Order Date: ").append(orderDate).append("\n");
        orderInfo.append("Order Status: ").append(orderStatus ? "Completed" : "Open").append("\n");
        orderInfo.append("Ordered Items:\n");
        
        for (Item item : orderItems) {
            orderInfo.append("- ").append(item.getItemInfo()).append("\n");
        }
        
        return orderInfo.toString();
    }
    
    // Getter for order ID, if needed to track specific orders
    public int orderID() {
        return orderID;
    }
}
