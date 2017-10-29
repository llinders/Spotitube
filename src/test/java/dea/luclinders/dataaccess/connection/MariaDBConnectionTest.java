package dea.luclinders.dataaccess.connection;

import dea.luclinders.dataaccess.connection.util.DatabasePropertiesTest;
import org.junit.Test;
import org.mariadb.jdbc.MariaDbConnection;
import org.mockito.InjectMocks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MariaDBConnectionTest {
    @InjectMocks
    private DatabaseConnectionFactory factory;

    @Test
    public void getConnection() throws SQLException {
        // init
        factory = mock(DatabaseConnectionFactory.class);
        when(factory.create()).thenReturn(DriverManager.getConnection(DatabasePropertiesTest.CONNECTION_URL, DatabasePropertiesTest.USER, DatabasePropertiesTest.PASS));

        // test
        Connection conn = factory.create();

        // check
        assertEquals(MariaDbConnection.class, conn.getClass());
    }

    @Test (expected = SQLException.class)
    public void getConnectionWrongConnectionUrl() throws SQLException {
        // init
        factory = mock(DatabaseConnectionFactory.class);
        when(factory.create()).thenReturn(DriverManager.getConnection("invalidconnectionurl", DatabasePropertiesTest.USER, DatabasePropertiesTest.PASS));

        // test
        factory.create();
    }

    @Test (expected = SQLException.class)
    public void getConnectionWrongUser() throws SQLException {
        // init
        factory = mock(DatabaseConnectionFactory.class);
        when(factory.create()).thenReturn(DriverManager.getConnection(DatabasePropertiesTest.CONNECTION_URL, "notauser", DatabasePropertiesTest.PASS));

        // test
        factory.create();
    }

    @Test (expected = SQLException.class)
    public void getConnectionWrongPass() throws SQLException {
        // init
        factory = mock(DatabaseConnectionFactory.class);
        when(factory.create()).thenReturn(DriverManager.getConnection(DatabasePropertiesTest.CONNECTION_URL, DatabasePropertiesTest.USER, "notavalidpass"));

        // test
        factory.create();
    }
}