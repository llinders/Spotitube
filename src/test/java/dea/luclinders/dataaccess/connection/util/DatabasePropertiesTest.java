package dea.luclinders.dataaccess.connection.util;

import dea.luclinders.dataaccess.connection.util.DatabaseProperties;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DatabasePropertiesTest {
    private DatabaseProperties properties;

    public static final String DRIVER = "org.mariadb.jdbc";
    public static final String CONNECTION_URL = "jdbc:mariadb://localhost:3306/Spotitube";
    public static final String USER = "root";
    public static final String PASS = "R8z%#sBRV^!po%#ztGO";

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

    //TODO: Remove commented code if not needed anymore
    /*@Test
    public void getConnectionUrl() {
        // test
        String connectionUrl = properties.getConnectionUrl();

        // check
        assertEquals(CONNECTION_URL, connectionUrl);
    }

    @Test
    public void getUser() {
        // test
        String user = properties.getUser();

        // check
        assertEquals(USER, user);
    }

    @Test
    public void getPassword() {
        // test
        String pass = properties.getPassword();

        // check
        assertEquals(PASS, pass);
    }*/
}