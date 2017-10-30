package dea.luclinders.dataaccess.dao.user;

import dea.luclinders.dataaccess.connection.DatabaseConnectionFactory;
import dea.luclinders.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO {
    private Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

    public User findByUsernameAndPassword(String username, String password) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM User WHERE username=? AND password=?");
            statement.setString(1, username);
            statement.setString(2, password);

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
        return null;
    }

    public void create(User entity) {

    }

    public void update(User entity) {

    }

    public void delete(User entity) {

    }

    public User find(int id) {
        return null;
    }
}
