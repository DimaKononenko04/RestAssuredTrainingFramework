package database_connection;

import database_connection.manager.DBManager;
import database_connection.manager.EmployeeManager;

import java.sql.SQLException;

public class Execute {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println(EmployeeManager.getAllEmployeesFromDB().get(0).getEmployeeId());
        DBManager.updateDB("update employees set employee_id=2, first_name='Tobi', last_name='dog', position='pet' where employee_id=2");
    }

}
