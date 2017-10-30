package dea.luclinders.services.rest;

import dea.luclinders.businesslogic.TokenGenerator;
import dea.luclinders.dataaccess.dao.user.UserDAO;
import dea.luclinders.domain.Token;
import dea.luclinders.domain.User;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("login")
public class UserRestServiceImpl implements UserRestService {
    @Inject
    private UserDAO userDAO;
    @Inject
    private TokenGenerator tokenGenerator;

    public Response getTokenByUsernameAndPassword(User user) {
        User u = userDAO.findByUsernameAndPassword(user.getUser(), user.getPassword());
        Token token = new Token(tokenGenerator.generateToken(), u);

        if (u == null) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }
        return Response.ok().entity(token).build();
    }
}