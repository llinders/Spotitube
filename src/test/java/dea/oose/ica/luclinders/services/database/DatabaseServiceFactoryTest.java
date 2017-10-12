package dea.oose.ica.luclinders.services.database;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class DatabaseServiceFactoryTest {
    private DatabaseServiceFactory factory;

    @Before
    public void setup() {
        factory = DatabaseServiceFactory.getInstance();
    }

    @Test
    public void createMariaDBService() throws DatabaseServiceNotKnownToFactoryException {
        // test
        IDatabaseService service = factory.create(DatabaseServiceType.MARIADB);

        // check
        assertEquals(MariaDBService.class, service.getClass());
    }

    @Test (expected = DatabaseServiceNotKnownToFactoryException.class)
    public void createNonExistingDatabaseService() throws DatabaseServiceNotKnownToFactoryException {
        // test
        IDatabaseService service = factory.create(DatabaseServiceType.NONEXISTENT);
    }
}