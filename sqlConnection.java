package CA4_CR;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class sqlConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
