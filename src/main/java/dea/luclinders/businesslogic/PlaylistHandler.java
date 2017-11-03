package dea.luclinders.businesslogic;

import dea.luclinders.domain.PlaylistList;

public interface PlaylistHandler {

    PlaylistList getAllAvailablePlaylists(String token) throws InvalidTokenException;

    void createPlaylist(String playlistName, String token) throws InvalidTokenException;

    void updatePlaylist(int playlistId, String updatedPlaylistName, String token) throws InvalidTokenException;

}
