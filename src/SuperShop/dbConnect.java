package SuperShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class dbConnect {
    private Connection conn; // Store the connection

    public void connect() {
        String url = "jdbc:mysql://localhost:3306/supershop"; // Change DB name
        String user = "root"; // Your MySQL username
        String password = ""; // Your MySQL password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
        }
    }

    public Connection getConnection() {
        return conn; // Return the connection for reuse
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection.");
        }
    }
}