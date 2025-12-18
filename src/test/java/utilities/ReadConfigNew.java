package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigNew {

    private static Properties properties;

    public ReadConfigNew() {

        try {
            String configPath = System.getProperty("user.dir")
                    + "/src/test/resources/config.properties";

            FileInputStream fis = new FileInputStream(configPath);

            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            System.out.println(" FAILED TO LOAD: config.properties ");
            e.printStackTrace();
        }
    }

    // ===== ENVIRONMENT =====
    public String getEnvironment() {
        return getValue("env", "QA");
    }

    // ===== BROWSER =====
    public String getBrowser() {
        return getValue("browser", "chrome");
    }

    // ===== HEADLESS =====
    public String getHeadless() {
        return getValue("headless", "false");
    }

    // ===== BASE URL =====
    public String getBaseURL() {
        return getValue("baseURL", "http://automationexercise.com");
    }

    // ===== USER EMAIL =====
    public String getUserEmail() {
        return getValue("userMail", "Tester@gmail.com");
    }

    // ===== USERNAME =====
    public String getUsername() {
        return getValue("username", "admin");
    }

    // ===== PASSWORD =====
    public String getPassword() {
        return getValue("password", "admin123");
    }

    // ===== GENERIC GET WITH DEFAULT =====
    private static String getValue(String key, String defaultValue) {

        if (properties == null) {
            throw new RuntimeException("properties is not loaded. Did you create ReadConfig object?");
        }

        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }

        return value;
    }

    // ===== STATIC ACCESS IF NEEDED =====
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
