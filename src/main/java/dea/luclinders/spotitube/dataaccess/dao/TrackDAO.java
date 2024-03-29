package dea.luclinders.spotitube.dataaccess.dao;

import dea.luclinders.spotitube.domain.Track;

import java.util.List;

public interface TrackDAO {

    List<Track> findTracksNotInPlaylist(int playlistId);

    List<Track> findTracksFromPlaylist(int playlistId);

    void deleteTrackFromPlaylist(int playlistId, int trackId);

    void addTrackToPlaylist(int playlistId, Track track);
}
