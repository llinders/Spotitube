package dea.luclinders.services.rest;

import dea.luclinders.businesslogic.SessionManager;
import dea.luclinders.businesslogic.TokenGenerator;
import dea.luclinders.dataaccess.dao.user.UserDAO;
import dea.luclinders.domain.Session;
import dea.luclinders.domain.User;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")
public class UserRestServiceImpl implements UserRestService {
    @Inject
    private UserDAO userDAO;
    @Inject
    private TokenGenerator tokenGenerator;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTokenByUsernameAndPassword(User user) {
        System.out.println(user.getUser() + " - " + user.getPassword());

        User u = userDAO.findByUsernameAndPassword(user.getUser(), user.getPassword());
        Session session = new Session(tokenGenerator.generateToken(), u);
        SessionManager.getInstance().addSession(session.getToken(), u);

        if (u == null) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }
        return Response.ok().entity(session).build();
    }
}
