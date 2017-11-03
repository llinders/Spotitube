package dea.luclinders.spotitube.businesslogic;

import dea.luclinders.spotitube.dataaccess.dao.playlist.PlaylistDAO;
import dea.luclinders.spotitube.domain.Playlist;
import dea.luclinders.spotitube.domain.PlaylistList;

import javax.inject.Inject;
import java.util.List;

public class PlaylistHandlerImpl implements PlaylistHandler {
    @Inject
    private PlaylistDAO playlistDAO;
    @Inject
    private PlaylistHelper playlistHelper;

    public PlaylistList getAllAvailablePlaylists(String token) throws InvalidTokenException {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        List<Playlist> playlists = playlistDAO.findAll(userId);
        return playlistHelper.makeOverview(playlists);
    }

    public void createPlaylist(String playlistName, String token) throws InvalidTokenException {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        Playlist playlist = new Playlist();
        playlist.setName(playlistName);
        playlist.setOwnerId(userId);

        playlistDAO.create(playlist);
    }

    public void updatePlaylist(int playlistId, String updatedPlaylistName, String token) throws InvalidTokenException {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        Playlist playlist = new Playlist();
        playlist.setId(playlistId);
        playlist.setName(updatedPlaylistName);
        playlist.setOwnerId(userId);

        playlistDAO.update(playlist);
    }
}
