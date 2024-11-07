import java.util.ArrayList;
import java.util.List;

public class Manager extends Staff {
    private List<Staff> subordinates;
    private List<Item> menu;

    // Constructor
    public Manager(int staffID, String name, Date dob, String phone, String email) {
        super(staffID, name, dob, phone, email, "Manager");
        this.subordinates = new ArrayList<>();
        this.menu = new ArrayList<>();
    }

    // Methods
    public void addMenuItem(Item item) {
        menu.add(item);
        System.out.println("Added item to menu: " + item.getName());
    }

    public void deleteItem(Item item) {
        menu.remove(item);
        System.out.println("Removed item from menu: " + item.getName());
    }

    public void getInventoryInfo() {
        System.out.println("Displaying inventory information.");
        // Implementation for getting inventory info
    }

    public void addStaff(Staff staff) {
        subordinates.add(staff);
        System.out.println("Added staff: " + staff.getName());
    }

    public void editStaff(Staff staff, String newName, String newPhone, String newEmail) {
        staff.name = newName;
        staff.phone = newPhone;
        staff.email = newEmail;
        System.out.println("Edited staff details for: " + staff.getName());
    }

    public void deleteStaff(Staff staff) {
        subordinates.remove(staff);
        System.out.println("Deleted staff: " + staff.getName());
    }

    public void viewStaff() {
        System.out.println("Viewing all subordinates:");
        for (Staff staff : subordinates) {
            System.out.println("- " + staff.getName());
        }
    }
}
