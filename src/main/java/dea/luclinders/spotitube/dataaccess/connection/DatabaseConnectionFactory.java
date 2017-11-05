package dea.luclinders.spotitube.dataaccess.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnectionFactory {
    private static DatabaseConnectionFactory instance;
    private Logger logger;
    private Connection conn;

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
            if (conn == null) {
                Class.forName(properties.getDriver());
                conn = DriverManager.getConnection(properties.getConnectionUrl(), properties.getUser(), properties.getPassword());
            }
        } catch (SQLException e) {
            logger.severe(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
