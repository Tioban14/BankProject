package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Auxiliary class to hold the database information
 */
public class Connect {
    private final String DB_URL = "jdbc:mysql://localhost/mybank?serverTimezone=UTC";
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";
    public static Connection connection = null;

    /**
     * Constructor makes connection with db
     * @return
     */
    public Connection getConnect(){
        try {
            return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Error in connection");
            return null;
        }
    }
}
