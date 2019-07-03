package xml_parsing;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;



@XmlRootElement
public class Employees {
    private ArrayList<Employee> employee;

    public Employees(){

    }

    public Employees(ArrayList<Employee> employee) {
        this.employee = employee;
    }

    @XmlElement
    public ArrayList<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(ArrayList<Employee> employee) {
        this.employee = employee;
    }
}
