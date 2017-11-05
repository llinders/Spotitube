package dea.luclinders.spotitube.dataaccess.dao;

import dea.luclinders.spotitube.dataaccess.connection.DatabaseConnectionFactory;
import dea.luclinders.spotitube.domain.Track;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TrackDAOImpl implements TrackDAO {
    private Logger logger = Logger.getLogger(TrackDAOImpl.class.getName());

    public List<Track> findTracksNotInPlaylist(int playlistId) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        List<Track> tracks;
        try {
            PreparedStatement fetchTracksNotInPlaylist = conn.prepareStatement("SELECT DISTINCT T.* FROM Track T LEFT JOIN PlaylistTrack PT ON T.id = PT.track_id WHERE T.id NOT IN (SELECT track_id FROM PlaylistTrack WHERE playlist_id = ?)");
            fetchTracksNotInPlaylist.setInt(1, playlistId);

            ResultSet tracksResultSet = fetchTracksNotInPlaylist.executeQuery();
            tracks = persistTracks(tracksResultSet, true);
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
            PreparedStatement fetchTracksFromPlaylist = conn.prepareStatement("SELECT T.*, PT.offline_available FROM Track T INNER JOIN PlaylistTrack PT ON T.id = PT.track_id WHERE PT.playlist_id = ?");
            fetchTracksFromPlaylist.setInt(1, playlistId);

            ResultSet tracksResultSet = fetchTracksFromPlaylist.executeQuery();
            tracks = persistTracks(tracksResultSet, false);
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to fetch tracks due to a persistance problem.", e);
        }
        return tracks;
    }

    public void deleteTrackFromPlaylist(int playlistId, int trackId) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        try {
            PreparedStatement deleteTrackFromPlaylist = conn.prepareStatement("DELETE FROM PlaylistTrack WHERE playlist_id = ? AND track_id = ?");
            deleteTrackFromPlaylist.setInt(1, playlistId);
            deleteTrackFromPlaylist.setInt(2, trackId);
            deleteTrackFromPlaylist.executeUpdate();
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to delete track due to a persistance problem.", e);
        }
    }

    public void addTrackToPlaylist(int playlistId, Track track) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        try {
            PreparedStatement addTrackToPlaylist = conn.prepareStatement("INSERT INTO PlaylistTrack VALUES(?, ?, ?)");
            addTrackToPlaylist.setInt(1, playlistId);
            addTrackToPlaylist.setInt(2, track.getId());
            addTrackToPlaylist.setBoolean(3, track.isOfflineAvailable());
            addTrackToPlaylist.executeUpdate();
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to add track due to a persistance problem.", e);
        }
    }

    private List<Track> persistTracks(ResultSet rs, boolean trackInfoOnly) throws SQLException {
        List<Track> tracks = new ArrayList<>();
        while (rs.next()) {
            Track track = new Track();
            track.setId(rs.getInt("id"));
            track.setTitle(rs.getString("title"));
            track.setPerformer(rs.getString("performer"));
            track.setDuration(rs.getInt("duration"));
            track.setAlbum(rs.getString("album"));
            track.setPlaycount(rs.getInt("playcount"));
            track.setDescription(rs.getString("description"));
            Date date = rs.getDate("publication_date");
            if (date != null) {
                track.setPublicationDate(String.valueOf(date));
            }
            if (!trackInfoOnly) {
                track.setOfflineAvailable(rs.getBoolean("offline_available"));
            } else {
                track.setOfflineAvailable(false);
            }

            tracks.add(track);
        }
        return tracks;
    }
}
