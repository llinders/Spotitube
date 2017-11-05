package dea.luclinders.spotitube.dataaccess.dao;

import dea.luclinders.spotitube.domain.User;

public interface UserDAO {

    User findByUsername(String username);
}
