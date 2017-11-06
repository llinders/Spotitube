package dea.luclinders.spotitube.service.rest;

import dea.luclinders.spotitube.businesslogic.TrackHandler;
import dea.luclinders.spotitube.businesslogic.session.InvalidTokenException;
import dea.luclinders.spotitube.domain.Track;
import dea.luclinders.spotitube.domain.TrackList;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("playlists")
public class PlaylistTrackRestService {
    @Inject
    private TrackHandler trackHandler;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{playlistId}/tracks")
    public Response getAllTracksFromPlaylist(@PathParam("playlistId") int playlistId, @QueryParam("token") String token) {
        TrackList tracks;
        try {
            tracks = trackHandler.findAllTracksFromPlaylist(playlistId, token);
        } catch (InvalidTokenException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(INVALID_TOKEN_RESPONSE).build();
        }
        return Response.ok().entity(tracks).build();
    }

    private final String INVALID_TOKEN_RESPONSE = "Token not valid";

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{playlistId}/tracks")
    public Response addTrackToPlaylist(@PathParam("playlistId") int playlistId, Track track, @QueryParam("token") String token) {
        TrackList tracks;
        try {
            trackHandler.addTrackToPlaylist(playlistId, track, token);
            tracks = trackHandler.findAllTracksFromPlaylist(playlistId, token);
        } catch (InvalidTokenException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(INVALID_TOKEN_RESPONSE).build();
        }
        return Response.ok().entity(tracks).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{playlistId}/tracks/{trackId}")
    public Response deleteTrackFromPlaylist(@PathParam("playlistId") int playlistId, @PathParam("trackId") int trackId, @QueryParam("token") String token) {
        TrackList tracks;
        try {
            trackHandler.deleteTrackFromPlaylist(playlistId, trackId, token);
            tracks = trackHandler.findAllTracksFromPlaylist(playlistId, token);
        } catch (InvalidTokenException e) {
            return Response.status(Response.Status.FORBIDDEN).entity(INVALID_TOKEN_RESPONSE).build();
        }
        return Response.ok().entity(tracks).build();
    }
}
