package dea.luclinders.spotitube.dataaccess.dao.track;

import dea.luclinders.spotitube.domain.Track;

import java.util.List;

public interface TrackDAO {

    List<Track> findTracksNotInPlaylist(int playlistId);

    List<Track> findTracksFromPlaylist(int playlistId);

}
