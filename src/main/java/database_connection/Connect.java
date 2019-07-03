package database_connection;

import com.restapi.manager.PropertiesManager;

import java.sql.*;

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



    public static void main(String[] args) throws SQLException {
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String connectionUrl = PropertiesManager.getAppPropertyValueByName("dbconnection","url");
//        Connection con = DriverManager.getConnection(connectionUrl);
//        Statement statement = con.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from employees");
        ResultSet resultSet = Connect.createStatement().executeQuery("select * from employees");
        while ( resultSet.next()){
            System.out.println(resultSet.getString("first_name").trim() +" "
                    + resultSet.getString("last_name").trim()
                    +" " + resultSet.getString("position"));
        }
//        String sqlInsert = "insert into pages"
//                + "(p_parent,p_name)"
//                + "values ('1','new line text')";
//        statement.executeUpdate(sqlUpdate);
    }

}