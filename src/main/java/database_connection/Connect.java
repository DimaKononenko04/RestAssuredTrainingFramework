package database_connection;

import java.sql.*;

public class Connect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=kramar_task1;integratedSecurity=true;";
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from pages");
        while ( resultSet.next()){
            System.out.println(resultSet.getString("p_id").trim() +" " + resultSet.getString("p_name"));
        }

//        String sqlUpdate = "insert into pages"
//                + "(p_parent,p_name)"
//                + "values ('1','new line text')";
//        statement.executeUpdate(sqlUpdate);
    }

}
