package dea.luclinders.spotitube.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("tracks")
public class TrackRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAvailableTracksForPlaylist(@QueryParam("forPlaylist") int playlistId, @QueryParam("token") String token) {
        return null;
    }
}
