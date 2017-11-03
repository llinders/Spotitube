package dea.luclinders.businesslogic;

import dea.luclinders.domain.Playlist;
import dea.luclinders.domain.PlaylistList;

public interface PlaylistHandler {

    PlaylistList getAllAvailablePlaylists(String token) throws InvalidTokenException;

    void createPlaylist(Playlist playlist, String token) throws InvalidTokenException;

}
