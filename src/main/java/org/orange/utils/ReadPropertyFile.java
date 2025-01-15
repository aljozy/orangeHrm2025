package org.orange.utils;

import org.orange.constants.FrameworkConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadPropertyFile {
    private ReadPropertyFile(){

    }
    public static String get(String key) throws Exception {

        String value = "";
        Properties property = new Properties();

        // Using try-catch to handle exceptions
        try (FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            property.load(file);
            value = property.getProperty(key);

            if (value == null) {
                throw new Exception("Property name " + key + " is not found ");
            }
        } catch (FileNotFoundException e) {
            throw new Exception("Config file not found: " + FrameworkConstants.getConfigFilePath(), e);
        } catch (Exception e) {
            throw new Exception("Error reading config file: " + FrameworkConstants.getConfigFilePath(), e);
        }

        return value;

    }



}
