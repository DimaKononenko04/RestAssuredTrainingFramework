package database_connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Execute {
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
