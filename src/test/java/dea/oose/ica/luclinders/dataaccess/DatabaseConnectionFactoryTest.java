package dea.oose.ica.luclinders.dataaccess;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class DatabaseConnectionFactoryTest {
    private DatabaseConnectionFactory factory;

    @Before
    public void setup() {
        factory = DatabaseConnectionFactory.getInstance();
    }

    @Test
    public void createMariaDBService() throws DatabaseConnectionTypeNotKnownToFactoryException {
        // test
        IDatabaseConnection service = factory.create(DatabaseConnectionType.MARIADB);

        // check
        assertEquals(MariaDBConnection.class, service.getClass());
    }

    @Test (expected = DatabaseConnectionTypeNotKnownToFactoryException.class)
    public void createNonExistingDatabaseService() throws DatabaseConnectionTypeNotKnownToFactoryException {
        // test
        IDatabaseConnection service = factory.create(DatabaseConnectionType.NONEXISTENT);
    }
}