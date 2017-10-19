package dea.oose.ica.luclinders.dataaccess;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabaseConnection {

    Connection getConnection() throws SQLException;

}
