package database_connection;

import utils.PropertiesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        List<Employee> employees = new ArrayList<>();
        ResultSet resultSet = Connect.createStatement().executeQuery("select * from employees");
        while ( resultSet.next()){
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt("employee_id"));
            employee.setFirstName(resultSet.getString("first_name").trim());
            employee.setLastName(resultSet.getString("last_name").trim());
            employee.setPosition(resultSet.getString("position").trim());
            employees.add(employee);
        }
        resultSet.close();
        System.out.println(employees.get(3).getEmployeeId());
        System.out.println(employees.get(3).getFirstName());

    }

}
