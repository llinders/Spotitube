package dea.luclinders.dataaccess.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabaseConnection {

    Connection getConnection() throws SQLException;

}
