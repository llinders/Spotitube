package dea.luclinders.spotitube.dataaccess.connection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DatabaseConnectionFactoryTest {
    @InjectMocks
    private DatabaseConnectionFactory factory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create_shouldReturnConnection() {
        // Test
        Connection conn = factory.create();

        // Verify
        assertThat(conn, is(notNullValue()));
    }
}