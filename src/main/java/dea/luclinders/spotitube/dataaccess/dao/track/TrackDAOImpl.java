package dea.luclinders.spotitube.dataaccess.dao.track;

import dea.luclinders.spotitube.dataaccess.connection.DatabaseConnectionFactory;
import dea.luclinders.spotitube.domain.Track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TrackDAOImpl implements TrackDAO {
    private Logger logger = Logger.getLogger(TrackDAOImpl.class.getName());

    public List<Track> findTracksNotInPlaylist(int playlistId) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        List<Track> tracks;
        try {
            PreparedStatement fetchTracksNotInPlaylist = conn.prepareStatement("SELECT * FROM Track WHERE playlist_id != ?");
            fetchTracksNotInPlaylist.setInt(1, playlistId);

            ResultSet tracksResultSet = fetchTracksNotInPlaylist.executeQuery();
            tracks = persistTracks(tracksResultSet);
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to fetch tracks due to a persistance problem.", e);
        }
        return tracks;
    }

    public List<Track> findTracksFromPlaylist(int playlistId) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        List<Track> tracks;
        try {
            PreparedStatement fetchTracksFromPlaylist = conn.prepareStatement("SELECT * FROM Track WHERE playlist_id = ?");
            fetchTracksFromPlaylist.setInt(1, playlistId);

            ResultSet tracksResultSet = fetchTracksFromPlaylist.executeQuery();
            tracks = persistTracks(tracksResultSet);
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to fetch tracks due to a persistance problem.", e);
        }
        return tracks;
    }

    private List<Track> persistTracks(ResultSet rs) throws SQLException {
        List<Track> tracks = new ArrayList<>();
        while (rs.next()) {
            Track track = new Track();
            track.setId(rs.getInt("id"));
            track.setTitle(rs.getString("title"));
            track.setPerformer(rs.getString("performer"));
            track.setDuration(rs.getInt("duration"));
            track.setAlbum(rs.getString("album"));
            track.setPlaycount(rs.getInt("playcount"));
            track.setPublicationDate(rs.getDate("publication_date"));
            track.setDescription(rs.getString("description"));
            track.setOfflineAvailable(rs.getBoolean("offline_available"));

            tracks.add(track);
        }
        return tracks;
    }
}