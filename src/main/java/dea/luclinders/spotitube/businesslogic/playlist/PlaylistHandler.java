package dea.luclinders.spotitube.businesslogic.playlist;

import dea.luclinders.spotitube.businesslogic.InvalidTokenException;
import dea.luclinders.spotitube.domain.PlaylistList;
import dea.luclinders.spotitube.domain.TrackList;
import dea.luclinders.spotitube.domain.UserPlaylist;

import java.util.List;

public interface PlaylistHandler {

    PlaylistList findAllAvailablePlaylists(String token) throws InvalidTokenException;

    void createPlaylist(String playlistName, String token) throws InvalidTokenException;

    void updatePlaylist(int playlistId, String updatedPlaylistName, String token) throws InvalidTokenException;

}
