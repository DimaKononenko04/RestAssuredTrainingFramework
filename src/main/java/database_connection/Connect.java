package database_connection;

import utils.PropertiesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connect {

    private static Connection createDbConnection(){
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



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String connectionUrl = PropertiesManager.getAppPropertyValueByName("dbconnection","url");
//        Connection con = DriverManager.getConnection(connectionUrl);
//        Statement statement = con.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from employees");
        List<Employee> employees = new ArrayList<>();
        ResultSet resultSet = Connect.createStatement().executeQuery("select * from employees");
        while ( resultSet.next()){
            Employee employee = new Employee();
            employee.setEmployeeId(Integer.parseInt(resultSet.getString("employee_id").trim()));
            employee.setFirstName(resultSet.getString("first_name").trim());
            employee.setLastName(resultSet.getString("last_name").trim());
            employee.setPosition(resultSet.getString("position").trim());
            employees.add(employee);
        }
        System.out.println(employees.get(1).getFirstName());
        System.out.println(employees.get(1).getEmployeeId());
//        String sqlInsert = "insert into pages"
//                + "(p_parent,p_name)"
//                + "values ('1','new line text')";
//        statement.executeUpdate(sqlUpdate);
    }

}
