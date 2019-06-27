package com.restapi.manager;

import java.util.ResourceBundle;

public class PropertiesManager {
    private static ResourceBundle appPropertiesBundle = ResourceBundle.getBundle("properties/access");

    public static String getAppPropertyValueByName(String propertyName){
        return appPropertiesBundle.getString(propertyName);
    }

}
