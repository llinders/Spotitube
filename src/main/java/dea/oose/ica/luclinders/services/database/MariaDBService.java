package dea.oose.ica.luclinders.services.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBService implements IDatabaseService {
    private Connection conn;
    private String connectionString;

    public MariaDBService(String connectionString) {
        this.connectionString = connectionString;
    }

    public Connection getConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(connectionString);
        }
        return conn;
    }
}
