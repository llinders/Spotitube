package dea.luclinders.services.rest;

import dea.luclinders.businesslogic.InvalidTokenException;
import dea.luclinders.businesslogic.PlaylistHandler;
import dea.luclinders.domain.PlaylistList;
import dea.luclinders.domain.UserPlaylist;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("playlists")
public class PlaylistRestServiceImpl implements PlaylistRestService {
    @Inject
    private PlaylistHandler playlistHandler;

    private final String INVALID_TOKEN_RESPONSE = "Token not valid";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAvailablePlaylists(@QueryParam("token") String token) {
        PlaylistList playlistList;
        try {
            playlistList = playlistHandler.getAllAvailablePlaylists(token);
        } catch (InvalidTokenException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(INVALID_TOKEN_RESPONSE).build();
        }
        return Response.ok().entity(playlistList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(UserPlaylist playlist, @QueryParam("token") String token) {
        PlaylistList playlistList;
        try {
            playlistHandler.createPlaylist(playlist.getName(), token);
            playlistList = playlistHandler.getAllAvailablePlaylists(token);
        } catch (InvalidTokenException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(INVALID_TOKEN_RESPONSE).build();
        }
        return Response.ok().entity(playlistList).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response editPlaylist(UserPlaylist playlist, @PathParam("id") int playlistId, @QueryParam("token") String token) {
        PlaylistList playlistList;
        try {
            playlistHandler.updatePlaylist(playlistId, playlist.getName(), token);
            playlistList = playlistHandler.getAllAvailablePlaylists(token);
        } catch (InvalidTokenException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(INVALID_TOKEN_RESPONSE).build();
        }
        return Response.ok().entity(playlistList).build();
    }
}
