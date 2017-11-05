package dea.luclinders.spotitube.dataaccess.dao;

import dea.luclinders.spotitube.dataaccess.connection.DatabaseConnectionFactory;
import dea.luclinders.spotitube.domain.User;

import javax.ws.rs.NotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO {
    private Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

    public User findByUsername(String username) throws NotFoundException {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM User WHERE username = ?");
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setFirstname(resultSet.getString("first_name"));
                u.setLastname(resultSet.getString("last_name"));
                u.setUser(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                return u;
            }
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to fetch a user due to a persistance problem.", e);
        }
        throw new NotFoundException("User not found");
    }
}
