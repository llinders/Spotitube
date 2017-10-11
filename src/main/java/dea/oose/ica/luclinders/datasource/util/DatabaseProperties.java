package dea.oose.ica.luclinders.datasource.util;

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
        init();
    }

    public static DatabaseProperties getInstance() {
        if (instance == null) {
            instance = new DatabaseProperties();
        }
        return instance;
    }

    private void init() {
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

    public String getConnectionString() {
        return properties.getProperty("connectionString");
    }
}
