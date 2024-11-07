/*This current code only works when the actual SQL Database is in place. For now, the Staff-based classes will be written using a separate Account.java
file within the HRM folder, which is much simpler to implement.*/
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
    private Connection connection;
    private String loggedInUser;  // Tracks currently logged-in user

    // Constructor to initialize DB connection
    public UserAuthSystem(String dbUrl, String dbUser, String dbPassword) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        loggedInUser = null;
    }

    // Login method
    public String login(String username, String password) {
        if (loggedInUser != null) {
            return "A user is already logged in. Please logout first.";
        }

        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT role FROM users WHERE username = ? AND password = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                loggedInUser = username;
                String role = rs.getString("role");
                return "Login successful. Role: " + role;
            } else {
                return "Invalid username or password.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "An error occurred during login.";
        }
    }

    // Logout method
    public String logout() {
        if (loggedInUser == null) {
            return "No user is currently logged in.";
        }
        
        String message = "User " + loggedInUser + " has been logged out.";
        loggedInUser = null;
        return message;
    }

    // Close DB connection
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            // Replace with your actual database connection details
            String dbUrl = "jdbc:mysql://localhost:3306/yourDatabase";
            String dbUser = "yourUsername";
            String dbPassword = "yourPassword";

            UserAuthSystem authSystem = new UserAuthSystem(dbUrl, dbUser, dbPassword);

            // Test login with Manager credentials
            System.out.println(authSystem.login("managerUser", "managerPass"));

            // Test logout
            System.out.println(authSystem.logout());

            // Test login with Waiter credentials
            System.out.println(authSystem.login("waiterUser", "waiterPass"));

            // Test invalid login
            System.out.println(authSystem.login("waiterUser", "wrongPass"));

            // Test logout
            System.out.println(authSystem.logout());

            authSystem.close();  // Close the database connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
