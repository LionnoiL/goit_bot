package org.example.properties;

import static org.example.properties.ApplicationProperties.RESOURCES_PATH;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesService {

    private PropertiesService() {
    }

    public static String getApplicationProperties(String fileName, String propertyName) {
        String propertyValue = "";
        File file = new File(RESOURCES_PATH + fileName);
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }
}
