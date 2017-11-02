package dea.luclinders.services.rest;

import dea.luclinders.businesslogic.PlaylistHelper;
import dea.luclinders.businesslogic.SessionManager;
import dea.luclinders.dataaccess.dao.playlist.PlaylistDAO;
import dea.luclinders.domain.Playlist;
import dea.luclinders.domain.PlaylistList;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("playlists")
public class PlaylistRestServiceImpl implements PlaylistRestService {
    @Inject
    private PlaylistDAO playlistDAO;
    @Inject
    private PlaylistHelper playlistHelper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAvailablePlaylists(@QueryParam("token") String token) {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        List<Playlist> playlists = playlistDAO.findAll(userId);
        PlaylistList playlistList = playlistHelper.makeOverview(playlists);
        return Response.ok().entity(playlistList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(Playlist playlist, @QueryParam("token") String token) {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        playlistDAO.create(playlist);

        List<Playlist> playlists = playlistDAO.findAll(userId);
        PlaylistList playlistList = playlistHelper.makeOverview(playlists);
        return Response.ok().entity(playlistList).build();
    }
}
