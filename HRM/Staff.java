import java.util.Date;

public class Staff {
    private Account account;
    private int staffID;
    private String name;
    private Date dob;
    private String phone;
    private String email;
    private String role;
    
    // Constructor
    public Staff(Account account, int staffID, String name, Date dob, String phone, String email, String role) {
        this.account = account;
        this.staffID = staffID;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }
    
    // Getters and Setters
    public Account getAccount() {
        return account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
    
    public int getStaffID() {
        return staffID;
    }
    
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getDob() {
        return dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    // Methods
    public void getOrderInfo() {
        // Implementation for getting order information
    }
    
    public void viewMenu() {
        // Implementation for viewing menu
    }
}