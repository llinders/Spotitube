package dea.luclinders.businesslogic;

import dea.luclinders.dataaccess.dao.playlist.PlaylistDAO;
import dea.luclinders.domain.Playlist;
import dea.luclinders.domain.PlaylistList;

import javax.inject.Inject;
import java.util.List;

public class PlaylistHandlerImpl implements  PlaylistHandler {
    @Inject
    private PlaylistDAO playlistDAO;
    @Inject
    private PlaylistHelper playlistHelper;

    public PlaylistList getAllAvailablePlaylists(String token) throws InvalidTokenException {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        List<Playlist> playlists = playlistDAO.findAll(userId);
        return playlistHelper.makeOverview(playlists);
    }

    public void createPlaylist(Playlist playlist, String token) throws InvalidTokenException {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        playlistDAO.create(playlist, userId);
    }
}
