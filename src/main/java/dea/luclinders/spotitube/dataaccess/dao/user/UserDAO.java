package dea.luclinders.spotitube.dataaccess.dao.user;

import dea.luclinders.spotitube.domain.User;

public interface UserDAO {

    User findByUsername(String username);
}
