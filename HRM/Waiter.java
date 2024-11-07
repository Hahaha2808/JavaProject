import java.util.ArrayList;
import java.util.List;

public class Waiter extends Staff {
    private List<Order> orders;

    // Constructor
    public Waiter(int staffID, String name, Date dob, String phone, String email) {
        super(staffID, name, dob, phone, email, "Waiter");
        this.orders = new ArrayList<>();
    }

    // Methods
    public void newOrder(Order order) {
        orders.add(order);
        System.out.println("New order created: " + order.getOrderID());
    }

    public void deleteOrder(Order order) {
        orders.remove(order);
        System.out.println("Order deleted: " + order.getOrderID());
    }

    public void generateInvoice(Order order) {
        System.out.println("Generating invoice for order: " + order.getOrderID());
        // Implementation for generating invoice
    }
}
