package dea.luclinders.dataaccess.dao.playlist;

import dea.luclinders.dataaccess.connection.DatabaseConnectionFactory;
import dea.luclinders.domain.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PlaylistDAOImpl implements PlaylistDAO {
    private Logger logger = Logger.getLogger(PlaylistDAOImpl.class.getName());

    public List<Playlist> findAll(int userId) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        List<Playlist> playlists = new ArrayList<>();
        try {
            PreparedStatement fetchAllPlaylistsStatement = conn.prepareStatement("SELECT * FROM Playlist");

            ResultSet playlistResultSet = fetchAllPlaylistsStatement.executeQuery();
            while (playlistResultSet.next()) {
                int playlistId = playlistResultSet.getInt("id");
                String playlistName = playlistResultSet.getString("name");
                int playlistOwnerId = playlistResultSet.getInt("owner_id");

                Playlist playlist = new Playlist();
                playlist.setId(playlistId);
                playlist.setName(playlistName);
                playlist.setTracks(new ArrayList<>());
                if (userId == playlistOwnerId) {
                    playlist.setOwner(true);
                } else {
                    playlist.setOwner(false);
                }

                PreparedStatement fetchTotalDurationOfAllTracks = conn.prepareStatement("SELECT SUM(duration) AS playlist_duration FROM Track WHERE playlist_id=?;");
                fetchTotalDurationOfAllTracks.setInt(1, playlistId);
                ResultSet totalTrackDurationResultSet = fetchTotalDurationOfAllTracks.executeQuery();
                totalTrackDurationResultSet.next();
                int playlistLength = totalTrackDurationResultSet.getInt("playlist_duration");

                playlist.setLength(playlistLength);

                playlists.add(playlist);
            }
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to fetch playlists due to a persistance problem.", e);
        }
        return playlists;
    }

    public void create(Playlist playlist, int userId) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        try {
            PreparedStatement insertPlaylist = conn.prepareStatement("INSERT INTO Playlist(name, owner_id) VALUES(?, ?)");
            insertPlaylist.setString(1, playlist.getName());
            insertPlaylist.setInt(2, userId);
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to create playlist due to a persistance problem.", e);
        }
    }
}
