package dea.luclinders.dataaccess.dao.playlist;

import com.sun.org.apache.regexp.internal.RE;
import dea.luclinders.dataaccess.connection.DatabaseConnectionFactory;
import dea.luclinders.domain.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAOImpl implements PlaylistDAO {
    
    public List<Playlist> findAll() {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        List<Playlist> playlists = new ArrayList<>();
        try {
            PreparedStatement fetchAllPlaylistsStatement = conn.prepareStatement("SELECT * FROM Playlist");

            ResultSet playlistResultSet = fetchAllPlaylistsStatement.executeQuery();
            while (playlistResultSet.next()) {
                Playlist playlist = new Playlist();
                playlist.setId(playlistResultSet.getInt("id"));
                playlist.setName(playlistResultSet.getString("name"));

                PreparedStatement fetchAllTracksFromPlaylistStatement = conn.prepareStatement("SELECT * FROM Tracks WHERE playlist_id=?");
                ResultSet tracksResultSet = fetchAllTracksFromPlaylistStatement.executeQuery();
                while (tracksResultSet.next()) {
                    //TODO: complete
                }

            }
        } catch (SQLException e) {

        }
        return null;
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
