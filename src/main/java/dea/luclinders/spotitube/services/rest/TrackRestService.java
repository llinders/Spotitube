package dea.luclinders.spotitube.services.rest;

import dea.luclinders.spotitube.businesslogic.InvalidTokenException;
import dea.luclinders.spotitube.businesslogic.track.TrackHandler;
import dea.luclinders.spotitube.domain.TrackList;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("tracks")
public class TrackRestService {
    @Inject
    private TrackHandler trackHandler;

    private final String INVALID_TOKEN_RESPONSE = "Token not valid";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAvailableTracksForPlaylist(@QueryParam("forPlaylist") int playlistId, @QueryParam("token") String token) {
        TrackList tracks;
        try {
            tracks = trackHandler.findAllAvailableTracksNotInPlaylist(playlistId, token);
        } catch (InvalidTokenException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(INVALID_TOKEN_RESPONSE).build();
        }
        return Response.ok().entity(tracks).build();
    }
}
