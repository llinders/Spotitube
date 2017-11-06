package dea.luclinders.spotitube.dataaccess.dao.impl;

import dea.luclinders.spotitube.dataaccess.DatabaseConnectionFactory;
import dea.luclinders.spotitube.dataaccess.dao.PlaylistDAO;
import dea.luclinders.spotitube.domain.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PlaylistDAOImpl implements PlaylistDAO {
    private Logger logger = Logger.getLogger(PlaylistDAOImpl.class.getName());

    public List<Playlist> findAll() {
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
                playlist.setOwnerId(playlistOwnerId);

                PreparedStatement fetchTotalDurationOfAllTracks = conn.prepareStatement("SELECT SUM(duration) AS playlist_duration FROM Track WHERE id IN (SELECT track_id FROM PlaylistTrack WHERE playlist_id = ?)");
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

    public Playlist find(int playlistId) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        Playlist playlist = new Playlist();
        try {
            PreparedStatement fetchPlaylistStatement = conn.prepareStatement("SELECT * FROM Playlist WHERE id = ?");
            fetchPlaylistStatement.setInt(1, playlistId);

            ResultSet playlistResultSet = fetchPlaylistStatement.executeQuery();
            playlistResultSet.next();
            playlist.setId(playlistId);
            playlist.setName(playlistResultSet.getString("name"));
            playlist.setOwnerId(playlistResultSet.getInt("owner_id"));

            PreparedStatement fetchTotalDurationOfAllTracks = conn.prepareStatement("SELECT SUM(duration) AS playlist_duration FROM Track WHERE id IN (SELECT playlist_id FROM PlaylistTrack WHERE playlist_id = ?)");
            fetchTotalDurationOfAllTracks.setInt(1, playlistId);
            ResultSet totalTrackDurationResultSet = fetchTotalDurationOfAllTracks.executeQuery();
            totalTrackDurationResultSet.next();
            int playlistLength = totalTrackDurationResultSet.getInt("playlist_duration");

            playlist.setLength(playlistLength);
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to fetch playlists due to a persistance problem.", e);
        }
        return playlist;
    }

    public void create(Playlist playlist) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        try {
            PreparedStatement insertPlaylist = conn.prepareStatement("INSERT INTO Playlist(name, owner_id) VALUES(?, ?)");
            insertPlaylist.setString(1, playlist.getName());
            insertPlaylist.setInt(2, playlist.getOwnerId());
            insertPlaylist.executeUpdate();
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to create playlist due to a persistance problem.", e);
        }
    }

    public void update(Playlist playlist) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        try {
            PreparedStatement updatePlaylist = conn.prepareStatement("UPDATE Playlist SET name = ? WHERE id = ? AND owner_id = ?");
            updatePlaylist.setString(1, playlist.getName());
            updatePlaylist.setInt(2, playlist.getId());
            updatePlaylist.setInt(3, playlist.getOwnerId());
            updatePlaylist.executeUpdate();
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to update playlist due to a persistance problem.", e);
        }
    }

    public void delete(int playlistId) {
        Connection conn = DatabaseConnectionFactory.getInstance().create();
        try {
            PreparedStatement deletePlaylist = conn.prepareStatement("DELETE FROM Playlist WHERE id = ?");
            deletePlaylist.setInt(1, playlistId);
            deletePlaylist.executeUpdate();
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException("Failed to update playlist due to a persistance problem.", e);
        }
    }
}
