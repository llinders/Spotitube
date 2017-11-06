package dea.luclinders.spotitube.businesslogic;

import dea.luclinders.spotitube.businesslogic.session.InvalidTokenException;
import dea.luclinders.spotitube.domain.PlaylistList;

public interface PlaylistHandler {

    PlaylistList findAllAvailablePlaylists(String token) throws InvalidTokenException;

    void createPlaylist(String playlistName, String token) throws InvalidTokenException;

    void updatePlaylist(int playlistId, String updatedPlaylistName, String token) throws InvalidTokenException;

    void deletePlaylist(int playlistId, String token) throws InvalidTokenException;
}
