package ro.unibuc.pao.persistence;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection dbConnection;

    private DBConnection() {
    }
public static Connection getConnection() throws SQLException {
        if(dbConnection==null)
        {
            String DB_URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB1";
            String DB_USERNAME = "PROIECTPAO";
            String DB_PASSWORD = "proiectPAO";
            dbConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }




        return dbConnection;
    }
}
