package dea.luclinders.dataaccess.connection;

import dea.luclinders.dataaccess.connection.util.DatabaseProperties;

public class DatabaseConnectionFactory {
    private static DatabaseConnectionFactory instance;
    private IDatabaseConnection service;

    private DatabaseConnectionFactory() {
    }

    public static DatabaseConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionFactory();
        }
        return instance;
    }

    public IDatabaseConnection create(DatabaseConnectionType type) throws DatabaseConnectionTypeNotKnownToFactoryException {
        DatabaseProperties properties = DatabaseProperties.getInstance();
        switch (type) {
            case MARIADB:
                service = new MariaDBConnection(properties.getConnectionUrl(), properties.getUser(), properties.getPassword());
                break;
            default:
                throw new DatabaseConnectionTypeNotKnownToFactoryException();
        }
        return service;
    }
}
