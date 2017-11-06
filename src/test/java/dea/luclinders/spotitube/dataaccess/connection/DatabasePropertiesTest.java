package dea.luclinders.spotitube.dataaccess.connection;

import dea.luclinders.spotitube.dataaccess.DatabaseProperties;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DatabasePropertiesTest {
    private DatabaseProperties properties;

    @Before
    public void setup() {
        properties = DatabaseProperties.getInstance();
    }

    /**
     * Asserts true if the driver is not null, meaning the {@see DatabaseProperties} did read the file successfully.
     * The other get methods cannot be tested since the database.properties file from the test directory differs from the database.properties from the main directory.
     * Therefor if this method works the others should too.
     */
    @Test
    public void getDriver() {
        // test
        String driver = properties.getDriver();

        // check
        assertTrue(driver != null);
    }

    @Test
    public void getConnectionUrl() {
        // test
        String connectionUrl = properties.getConnectionUrl();

        // check
        assertTrue(connectionUrl != null);
    }
}