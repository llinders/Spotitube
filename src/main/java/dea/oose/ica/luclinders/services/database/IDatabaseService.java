package dea.oose.ica.luclinders.services.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabaseService {

    Connection getConnection() throws SQLException;

}
