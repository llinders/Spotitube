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
                Playlist playlist = new Playlist();
                playlist.setId(playlistResultSet.getInt("id"));
                playlist.setName(playlistResultSet.getString("name"));
                playlist.setTracks(new ArrayList<>());

                if (userId == playlistResultSet.getInt("owner_id")) {
                    playlist.setOwner(true);
                } else {
                    playlist.setOwner(false);
                }

                playlists.add(playlist);
                /*PreparedStatement fetchAllTracksFromPlaylistStatement = conn.prepareStatement("SELECT * FROM Tracks WHERE playlist_id=?");
                ResultSet tracksResultSet = fetchAllTracksFromPlaylistStatement.executeQuery();
                while (tracksResultSet.next()) {
                    //TODO: complete
                }*/
            }
        } catch (SQLException e) {
            logger.severe(e.getSQLState());
            throw new RuntimeException("Failed to fetch playlists due to a persistance problem.", e);
        }
        return playlists;
    }

    public void create(Playlist playlist) {

    }

    public void update(Playlist playlist) {

    }

    public void delete(Playlist playlist) {

    }

    public Playlist find(int id) {
        return null;
    }
}
