package dea.luclinders.spotitube.services.rest;

import dea.luclinders.spotitube.domain.UserPlaylist;

import javax.ws.rs.core.Response;

public interface PlaylistRestService {

    Response getAllAvailablePlaylists(String token);

    Response addPlaylist(UserPlaylist playlist, String token);

    Response editPlaylist(UserPlaylist playlist, int playlistId, String token);

}
