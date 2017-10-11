package dea.oose.ica.luclinders.datasource.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection conn;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection(DatabaseProperties p) throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(p.getConnectionString());
        }
        return conn;
    }

}
