package dea.luclinders.services.rest;

import dea.luclinders.dataaccess.dao.user.UserDAO;
import dea.luclinders.domain.User;
import dea.luclinders.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")
public class UserRestService implements UserService {
    @Inject
    private UserDAO userDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTokenByUsernameAndPassword(User user) {
        //TODO: remove sout
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        User u = userDAO.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (u == null) {
            //return error code: user not found
        }
        return null;
    }
}
