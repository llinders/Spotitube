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
        User u = userDAO.findByUsernameAndPassword(user.getUser(), user.getPassword());

        if (u == null) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }
        return Response.ok().entity(u).build();
    }
}
