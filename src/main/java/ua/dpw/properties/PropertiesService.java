package ua.dpw.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertiesService {

    public static String getApplicationProperties(String fileName, String propertyName) {
        String propertyValue = "";
        File file = new File(fileName);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException e) {
            log.error("Error read properties file {}", fileName);
        }
        return propertyValue;
    }
}
