package dependencies.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection getConnection(String dbUsername, String dbPassword) throws SQLException, ClassNotFoundException {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = Config.DB_URL;
        String dbName = Config.DB_NAME;
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        return con;
    }
}
