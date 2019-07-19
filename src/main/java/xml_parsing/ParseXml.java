package xml_parsing;


import utils.PropertiesManager;

import javax.swing.text.AbstractWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;

public class ParseXml {

    public static Employees getEmployees(){
        return new Employees();
    }

    public static Employees getEmployees(Object object){
        Employees employees = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            if(object instanceof File) {
                employees = (Employees) unmarshaller.unmarshal((File) object);
            }else if (object instanceof String){
                employees = (Employees) unmarshaller.unmarshal(new StringReader((String) object));
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void main(String[] args) {
        File file = new File(PropertiesManager.getAppPropertyValueByName("xmlpath","employees_xml_file_path"));
        String string = "<employees>\n" +
                "    <employee id=\"111\">\n" +
                "        <firstName>Lokesh</firstName>\n" +
                "        <lastName>Gupta</lastName>\n" +
                "        <location>India</location>\n" +
                "    </employee>\n" +
                "    <employee id=\"222\">\n" +
                "        <firstName>Alex</firstName>\n" +
                "        <lastName>Gussin</lastName>\n" +
                "        <location>Russia</location>\n" +
                "    </employee>\n" +
                "    <employee id=\"333\">\n" +
                "        <firstName>David</firstName>\n" +
                "        <lastName>Feezor</lastName>\n" +
                "        <location>USA</location>\n" +
                "    </employee>\n" +
                "</employees>";
        System.out.println(ParseXml.getEmployees(string).getEmployee().get(2).getId());
    }

}
