package dea.luclinders.services.rest;

import dea.luclinders.domain.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface UserRestService {

    Response getTokenByUsernameAndPassword(User user);

}
