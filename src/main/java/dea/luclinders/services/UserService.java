package dea.luclinders.services;

import dea.luclinders.domain.User;

import javax.ws.rs.core.Response;

public interface UserService {

    Response getTokenByUsernameAndPassword(User user);

}
