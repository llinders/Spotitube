package dea.luclinders.dataaccess;

import dea.luclinders.dataaccess.connection.MariaDBConnection;
import dea.luclinders.datasource.util.DatabasePropertiesTest;
import dea.luclinders.dataaccess.connection.DatabaseConnectionFactory;
import dea.luclinders.dataaccess.connection.DatabaseConnectionType;
import dea.luclinders.dataaccess.connection.DatabaseConnectionTypeNotKnownToFactoryException;
import org.junit.Test;
import org.mariadb.jdbc.MariaDbConnection;
import org.mockito.InjectMocks;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MariaDBConnectionTest {
    @InjectMocks
    private DatabaseConnectionFactory factory;

    @Test
    public void getConnection() throws SQLException, DatabaseConnectionTypeNotKnownToFactoryException {
        // init
        factory = mock(DatabaseConnectionFactory.class);
        when(factory.create(DatabaseConnectionType.MARIADB)).thenReturn(new MariaDBConnection(DatabasePropertiesTest.CONNECTION_URL, DatabasePropertiesTest.USER, DatabasePropertiesTest.PASS));

        // test
        Connection conn = factory.create(DatabaseConnectionType.MARIADB).getConnection();

        // check
        assertEquals(MariaDbConnection.class, conn.getClass());
    }

    @Test (expected = SQLException.class)
    public void getConnectionWrongConnectionUrl() throws SQLException, DatabaseConnectionTypeNotKnownToFactoryException {
        // init
        factory = mock(DatabaseConnectionFactory.class);
        when(factory.create(DatabaseConnectionType.MARIADB)).thenReturn(new MariaDBConnection("invalidconnectionurl", DatabasePropertiesTest.USER, DatabasePropertiesTest.PASS));

        // test
        factory.create(DatabaseConnectionType.MARIADB).getConnection();
    }

    @Test (expected = SQLException.class)
    public void getConnectionWrongUser() throws SQLException, DatabaseConnectionTypeNotKnownToFactoryException {
        // init
        factory = mock(DatabaseConnectionFactory.class);
        when(factory.create(DatabaseConnectionType.MARIADB)).thenReturn(new MariaDBConnection(DatabasePropertiesTest.CONNECTION_URL, "notauser", DatabasePropertiesTest.PASS));

        // test
        factory.create(DatabaseConnectionType.MARIADB).getConnection();
    }

    @Test (expected = SQLException.class)
    public void getConnectionWrongPass() throws SQLException, DatabaseConnectionTypeNotKnownToFactoryException {
        // init
        factory = mock(DatabaseConnectionFactory.class);
        when(factory.create(DatabaseConnectionType.MARIADB)).thenReturn(new MariaDBConnection(DatabasePropertiesTest.CONNECTION_URL, DatabasePropertiesTest.USER, "notavalidpass"));

        // test
        factory.create(DatabaseConnectionType.MARIADB).getConnection();
    }
}