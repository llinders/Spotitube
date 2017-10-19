package dea.oose.ica.luclinders.services.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBService implements IDatabaseService {
    private Connection conn;
    private String connectionUrl;
    private String user;
    private String pass;

    public MariaDBService(String connectionUrl, String user, String pass) {
        this.connectionUrl = connectionUrl;
        this.user = user;
        this.pass = pass;
    }

    public Connection getConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(connectionUrl, user, pass);
        }
        return conn;
    }
}
