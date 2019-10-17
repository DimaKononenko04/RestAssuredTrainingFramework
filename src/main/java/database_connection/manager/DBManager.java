package database_connection.manager;

import utils.PropertiesManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

    public static Connection createDbConnection(){
        String connectionUrl = PropertiesManager.getPropertyValueByName("dbconnection","url");
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

    public static void updateDB(String sql){
        int rowsAffected = 0;
        try {
            rowsAffected = createStatement().executeUpdate(sql);
            System.out.println("DB updated successfully,\n" + rowsAffected + " rows affected" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
