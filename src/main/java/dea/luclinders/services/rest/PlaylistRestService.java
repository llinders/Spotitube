package dea.luclinders.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface PlaylistRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getAllAvailablePlaylists();

}
