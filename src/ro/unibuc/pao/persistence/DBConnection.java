package ro.unibuc.pao.persistence;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB1";
    private static final String DB_USERNAME = "PROIECTPAO";
    private static final String DB_PASSWORD = "proiectPAO";

    private static Connection connection;

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }
        return connection;
    }
}
