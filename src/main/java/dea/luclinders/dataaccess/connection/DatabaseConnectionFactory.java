package dea.luclinders.dataaccess.connection;

import dea.luclinders.dataaccess.connection.util.DatabaseProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnectionFactory {
    private static DatabaseConnectionFactory instance;
    private Logger logger;

    private DatabaseConnectionFactory() {
        logger = Logger.getLogger(DatabaseConnectionFactory.class.getName());
    }

    public static DatabaseConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionFactory();
        }
        return instance;
    }

    public Connection create() {
        DatabaseProperties properties = DatabaseProperties.getInstance();
        try {
            return DriverManager.getConnection(properties.getConnectionUrl(), properties.getUser(), properties.getPassword());
        } catch(SQLException e) {
            logger.severe(e.getMessage());
        }
        return null;
    }
}
