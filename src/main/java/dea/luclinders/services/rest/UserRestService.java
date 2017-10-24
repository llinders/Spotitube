package dea.luclinders.services.rest;

import dea.luclinders.dataaccess.dao.user.UserDAO;
import dea.luclinders.domain.User;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

public class UserRestService {
    @Inject
    UserDAO userDAO;

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        //TODO: remove sout
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        User u = userDAO.findByUsername(user.getUsername());

        if (u == null) {
            //return error code: user not found
        }
        if (!u.getPassword().equals(user.getPassword())) {
            //return error code: wrong username or password
        }
        return null;
    }
}
