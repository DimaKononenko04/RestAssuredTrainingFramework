package database_connection;

import utils.PropertiesManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    public static Connection createDbConnection(){
        String connectionUrl = PropertiesManager.getAppPropertyValueByName("dbconnection","url");
        Connection connnection = null;
        try {
            connnection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connnection;
    }

    public static Statement createStatement(){
        Statement statement = null;
        try {
            statement = createDbConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

}
