package dea.luclinders.spotitube.services.rest;

import dea.luclinders.spotitube.businesslogic.LoginHandler;
import dea.luclinders.spotitube.domain.LoginRequest;
import dea.luclinders.spotitube.domain.Session;

import javax.inject.Inject;
import javax.security.auth.login.CredentialException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")
public class UserRestServiceImpl implements UserRestService {
    @Inject
    private LoginHandler loginHandler;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTokenByUsernameAndPassword(LoginRequest loginRequest) {
        Session session;
        try {
            session = loginHandler.checkCredentials(loginRequest.getUser(), loginRequest.getPassword());
        } catch (CredentialException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }
        return Response.ok().entity(session).build();
    }
}
