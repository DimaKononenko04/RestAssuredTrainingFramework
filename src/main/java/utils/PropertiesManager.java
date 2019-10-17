package utils;

import java.util.ResourceBundle;

public class PropertiesManager {

    public static String getPropertyValueByName(String propertyName, String propertyKey){
        ResourceBundle appPropertiesBundle = ResourceBundle.getBundle("properties/"+propertyName);
        return appPropertiesBundle.getString(propertyKey);
    }

}
