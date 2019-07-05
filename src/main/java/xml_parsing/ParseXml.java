package xml_parsing;


import utils.PropertiesManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;

public class ParseXml {

    public static Employees getEmployees(){
        File file = new File(PropertiesManager.getAppPropertyValueByName("xmlpath","employees_xml_file_path"));
        Employees employees = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            employees = (Employees) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static Employees getEmployees(String xmlString){
        Employees employees = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            employees = (Employees) unmarshaller.unmarshal(new StringReader(xmlString));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void main(String[] args) {
        System.out.println(ParseXml.getEmployees().getEmployee().get(2).getId());
    }

}
