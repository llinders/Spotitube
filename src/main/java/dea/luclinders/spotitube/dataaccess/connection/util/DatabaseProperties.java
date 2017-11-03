package dea.luclinders.spotitube.dataaccess.connection.util;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseProperties {
    private static DatabaseProperties instance;
    private Logger logger = Logger.getLogger(getClass().getName());
    private Properties properties;

    private final String PROPERTIES_FILE = "database.properties";

    private DatabaseProperties() {
        loadPropertyFile();
    }

    public static DatabaseProperties getInstance() {
        if (instance == null) {
            instance = new DatabaseProperties();
        }
        return instance;
    }

    private void loadPropertyFile() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading property file + " + PROPERTIES_FILE, e);
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "Could not find file '" + PROPERTIES_FILE, e);
        }
    }

    public String getDriver() {
        return properties.getProperty("driver");
    }

    public String getConnectionUrl() {
        return properties.getProperty("connectionUrl");
    }

    public String getUser() {
        return properties.getProperty("user");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}
