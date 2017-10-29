package dea.luclinders.dataaccess.connection;

import org.junit.Before;

public class DatabaseConnectionFactoryTest {
    private DatabaseConnectionFactory factory;

    @Before
    public void setup() {
        factory = DatabaseConnectionFactory.getInstance();
    }
}