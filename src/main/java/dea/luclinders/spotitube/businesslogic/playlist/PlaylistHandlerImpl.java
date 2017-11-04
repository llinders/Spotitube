package dea.luclinders.spotitube.businesslogic.playlist;

import dea.luclinders.spotitube.businesslogic.InvalidTokenException;
import dea.luclinders.spotitube.businesslogic.SessionManager;
import dea.luclinders.spotitube.dataaccess.dao.playlist.PlaylistDAO;
import dea.luclinders.spotitube.domain.Playlist;
import dea.luclinders.spotitube.domain.PlaylistList;
import dea.luclinders.spotitube.domain.UserPlaylist;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class PlaylistHandlerImpl implements PlaylistHandler {
    @Inject
    private PlaylistDAO playlistDAO;

    public PlaylistList findAllAvailablePlaylists(String token) throws InvalidTokenException {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        List<Playlist> playlists = playlistDAO.findAll();
        List<UserPlaylist> userPlaylists = convertPlaylistToUserPlaylist(playlists, userId);

        return makePlaylistOverview(userPlaylists);
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

    public void deletePlaylist(int playlistId, String token) throws InvalidTokenException {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        int playlistOwnerId = playlistDAO.find(playlistId).getOwnerId();
        if (userId == playlistOwnerId) {
            playlistDAO.delete(playlistId);
        }
    }

    private List<UserPlaylist> convertPlaylistToUserPlaylist(List<Playlist> playlists, int userId) {
        List<UserPlaylist> userPlaylists = new ArrayList<>(playlists.size());
        for (Playlist p : playlists) {
            UserPlaylist userPlaylist = new UserPlaylist();
            userPlaylist.setId(p.getId());
            userPlaylist.setName(p.getName());
            userPlaylist.setTracks(new ArrayList<>());
            userPlaylist.setLength(p.getLength());
            userPlaylist.setOwner(false);
            if (p.getOwnerId() == userId) {
                userPlaylist.setOwner(true);
            }
            userPlaylists.add(userPlaylist);
        }
        return userPlaylists;
    }

    private PlaylistList makePlaylistOverview(List<UserPlaylist> playlists) {
        int totalLength = 0;
        for (UserPlaylist playlist : playlists) {
            totalLength += playlist.getLength();
        }
        return new PlaylistList(playlists, totalLength);
    }
}
