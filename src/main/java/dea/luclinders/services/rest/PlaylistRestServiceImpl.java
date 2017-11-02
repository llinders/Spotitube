package dea.luclinders.services.rest;

import dea.luclinders.businesslogic.SessionManager;
import dea.luclinders.dataaccess.dao.playlist.PlaylistDAO;
import dea.luclinders.domain.Playlist;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("playlists")
public class PlaylistRestServiceImpl implements PlaylistRestService {
    @Inject
    private PlaylistDAO playlistDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAvailablePlaylists(@QueryParam("token") String token) {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        List<Playlist> playlists = playlistDAO.findAll(userId);
        return Response.ok().entity(playlists).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(@QueryParam("token") String token) {

        return null;
    }
}
