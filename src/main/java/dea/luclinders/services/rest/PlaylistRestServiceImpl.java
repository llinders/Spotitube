package dea.luclinders.services.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("playlists")
public class PlaylistRestServiceImpl implements PlaylistRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAvailablePlaylists() {

        return Response.ok().entity("werkt dit?").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(@QueryParam("token") String token) {
        return null;
    }

}
