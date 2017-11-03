package dea.luclinders.spotitube.businesslogic;

import dea.luclinders.spotitube.domain.PlaylistList;

public interface PlaylistHandler {

    PlaylistList getAllAvailablePlaylists(String token) throws InvalidTokenException;

    void createPlaylist(String playlistName, String token) throws InvalidTokenException;

    void updatePlaylist(int playlistId, String updatedPlaylistName, String token) throws InvalidTokenException;

}
