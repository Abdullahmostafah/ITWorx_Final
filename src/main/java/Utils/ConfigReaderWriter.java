package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReaderWriter {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReaderWriter.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Unable to find config.properties in src/test/resources");
            }
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Failed to load config.properties from src/test/resources: " + e.getMessage());
            throw new RuntimeException("Configuration file loading failed", e);
        }
    }

    public static String getPropKey(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in config.properties");
        }
        return value;
    }
}