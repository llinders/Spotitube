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

    public IDatabaseService create(DatabaseServiceType type) {
        DatabaseProperties databaseProperties = DatabaseProperties.getInstance();
        switch (type) {
            case MARIADB:
                service = new MariaDBService(databaseProperties.getConnectionString());
                break;
            default:

        }
        return service;
    }
}
