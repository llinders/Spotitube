package dea.luclinders.services.rest;

import dea.luclinders.domain.Playlist;

import javax.ws.rs.core.Response;

public interface PlaylistRestService {

    Response getAllAvailablePlaylists(String token);

    Response addPlaylist(Playlist playlist, String token);

}
