package dea.oose.ica.luclinders.services.database;

import dea.oose.ica.luclinders.datasource.util.DatabasePropertiesTest;
import org.junit.Test;
import org.mariadb.jdbc.MariaDbConnection;
import org.mockito.InjectMocks;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MariaDBServiceTest {
    @InjectMocks
    private DatabaseServiceFactory factory;

    @Test
    public void getConnection() throws SQLException, DatabaseServiceNotKnownToFactoryException {
        // init
        factory = mock(DatabaseServiceFactory.class);
        when(factory.create(DatabaseServiceType.MARIADB)).thenReturn(new MariaDBService(DatabasePropertiesTest.CONNECTION_URL, DatabasePropertiesTest.USER, DatabasePropertiesTest.PASS));

        // test
        Connection conn = factory.create(DatabaseServiceType.MARIADB).getConnection();

        // check
        assertEquals(MariaDbConnection.class, conn.getClass());
    }

    @Test (expected = SQLException.class)
    public void getConnectionWrongConnectionUrl() throws SQLException, DatabaseServiceNotKnownToFactoryException {
        // init
        factory = mock(DatabaseServiceFactory.class);
        when(factory.create(DatabaseServiceType.MARIADB)).thenReturn(new MariaDBService("invalidconnectionurl", DatabasePropertiesTest.USER, DatabasePropertiesTest.PASS));

        // test
        factory.create(DatabaseServiceType.MARIADB).getConnection();
    }

    @Test (expected = SQLException.class)
    public void getConnectionWrongUser() throws SQLException, DatabaseServiceNotKnownToFactoryException {
        // init
        factory = mock(DatabaseServiceFactory.class);
        when(factory.create(DatabaseServiceType.MARIADB)).thenReturn(new MariaDBService(DatabasePropertiesTest.CONNECTION_URL, "notauser", DatabasePropertiesTest.PASS));

        // test
        factory.create(DatabaseServiceType.MARIADB).getConnection();
    }

    @Test (expected = SQLException.class)
    public void getConnectionWrongPass() throws SQLException, DatabaseServiceNotKnownToFactoryException {
        // init
        factory = mock(DatabaseServiceFactory.class);
        when(factory.create(DatabaseServiceType.MARIADB)).thenReturn(new MariaDBService(DatabasePropertiesTest.CONNECTION_URL, DatabasePropertiesTest.USER, "notavalidpass"));

        // test
        factory.create(DatabaseServiceType.MARIADB).getConnection();
    }
}