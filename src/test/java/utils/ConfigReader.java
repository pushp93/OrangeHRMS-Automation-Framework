package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties prop;

    public static Properties loadProperties() {

        prop = new Properties();

        try {

            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") +
                    "/src/test/resources/config/config.properties");

            prop.load(fis);

        } catch(IOException e) {

            e.printStackTrace();
        }

        return prop;
    }

    public static String getProperty(String key) {

        loadProperties();

        return prop.getProperty(key);
    }

	
}

