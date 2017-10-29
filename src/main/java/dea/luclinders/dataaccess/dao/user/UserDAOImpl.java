package dea.luclinders.dataaccess.dao.user;

import dea.luclinders.dataaccess.connection.DatabaseConnectionFactory;
import dea.luclinders.domain.User;

import java.sql.Connection;

public class UserDAOImpl implements UserDAO {

    public User findByUsernameAndPassword(String username, String password) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
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
