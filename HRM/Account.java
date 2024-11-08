public class Account {
    private String username;
    private String password;
    
    // Constructor
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    // Getters and Setters
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    // Methods
    public boolean login() {
        // Implementation for login logic
        return true;
    }
    
    public void logout() {
        // Implementation for logout logic
    }
}