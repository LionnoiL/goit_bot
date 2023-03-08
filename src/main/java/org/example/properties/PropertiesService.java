package org.example.properties;

import static org.example.properties.ApplicationProperties.RESOURCES_PATH;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import org.example.AppLauncher;
import org.example.users.User;

public class PropertiesService {

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

  public static User getUserById(long id) {
    Map<Integer, User> users = AppLauncher.APPLICATION_PROPERTIES.getUsers();
    return users.get(id);
  }
}
