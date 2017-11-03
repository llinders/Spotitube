package dea.luclinders.spotitube.dataaccess.connection;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DatabaseConnectionFactoryTest {
    private DatabaseConnectionFactory factory;

    @Before
    public void setup() {
        factory = DatabaseConnectionFactory.getInstance();
    }

    @Test
    public void create_shouldReturnConnection() {
        // Test
        Connection conn = factory.create();

        // Verify
        assertThat(conn, is(notNullValue()));
    }
}