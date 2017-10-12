package dea.oose.ica.luclinders.services.database;

import dea.oose.ica.luclinders.datasource.util.DatabaseProperties;

public class DatabaseServiceFactory {
    private static DatabaseServiceFactory instance;
    private IDatabaseService service;

    private DatabaseServiceFactory() {
    }

    public static DatabaseServiceFactory getInstance() {
        if (instance == null) {
            instance = new DatabaseServiceFactory();
        }
        return instance;
    }

    public IDatabaseService create(DatabaseServiceType type) throws DatabaseServiceNotKnownToFactoryException {
        DatabaseProperties properties = DatabaseProperties.getInstance();
        switch (type) {
            case MARIADB:
                service = new MariaDBService(properties.getConnectionUrl(), properties.getUser(), properties.getPassword());
                break;
            default:
                throw new DatabaseServiceNotKnownToFactoryException();
        }
        return service;
    }
}
