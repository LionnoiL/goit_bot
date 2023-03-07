package org.example.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesService {

  private static final String RESOURCES_PATH = "src/main/resources/";

  public static String getApplicationProperties(String fileName, String propertyName) {
    String propertyValue = "";
    try {
      Properties properties = new Properties();
      File file = new File(RESOURCES_PATH + fileName);
      properties.load(new FileInputStream(file));
      propertyValue = properties.getProperty(propertyName);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return propertyValue;
  }
}
