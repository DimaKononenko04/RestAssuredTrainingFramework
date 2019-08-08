package database_connection.manager;

import database_connection.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    public static List<Employee> getAllEmployeesFromDB() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        ResultSet resultSet = DBManager.createStatement().executeQuery("select * from employees");
        while ( resultSet.next()){
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt("employee_id"));
            employee.setFirstName(resultSet.getString("first_name").trim());
            employee.setLastName(resultSet.getString("last_name").trim());
            employee.setPosition(resultSet.getString("position").trim());
            employees.add(employee);
        }
        resultSet.close();
        return employees;
    }
}
