package dea.luclinders.services.rest;

import javax.ws.rs.core.Response;

public interface PlaylistRestService {

    Response getAllAvailablePlaylists(String token);

    Response addPlaylist(String token);

}
