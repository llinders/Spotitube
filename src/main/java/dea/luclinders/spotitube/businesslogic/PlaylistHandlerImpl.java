package dea.luclinders.spotitube.businesslogic;

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
    @Inject
    private PlaylistHelper playlistHelper;

    public PlaylistList getAllAvailablePlaylists(String token) throws InvalidTokenException {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        List<Playlist> playlists = playlistDAO.findAll();
        System.out.println("Before: " + playlists);
        List<UserPlaylist> userPlaylists = convertPlaylistToUserPlaylist(playlists, userId);

        System.out.println("After: " + userPlaylists);

        return playlistHelper.makeOverview(userPlaylists);
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
}
