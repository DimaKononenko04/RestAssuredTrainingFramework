package database_connection.model;

import lombok.Data;

@Data
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String position;
}
