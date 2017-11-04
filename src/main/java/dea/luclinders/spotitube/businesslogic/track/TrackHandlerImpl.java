package dea.luclinders.spotitube.businesslogic.track;

import dea.luclinders.spotitube.businesslogic.InvalidTokenException;
import dea.luclinders.spotitube.businesslogic.SessionManager;
import dea.luclinders.spotitube.dataaccess.dao.playlist.PlaylistDAO;
import dea.luclinders.spotitube.dataaccess.dao.track.TrackDAO;
import dea.luclinders.spotitube.domain.TrackList;

import javax.inject.Inject;

public class TrackHandlerImpl implements TrackHandler {
    @Inject
    private TrackDAO trackDAO;
    @Inject
    private PlaylistDAO playlistDAO;

    private final String INVALID_TOKEN_MESSAGE = "Token is not registered";

    public TrackList findAllAvailableTracksNotInPlaylist(int playlistId, String token) throws InvalidTokenException {
        if (SessionManager.getInstance().isValid(token)) {
            TrackList trackList = new TrackList();
            trackList.setTracks(trackDAO.findTracksNotInPlaylist(playlistId));
            return trackList;
        }
        throw new InvalidTokenException(INVALID_TOKEN_MESSAGE);
    }

    public TrackList findAllTracksFromPlaylist(int playlistId, String token) throws InvalidTokenException {
        if (SessionManager.getInstance().isValid(token)) {
            TrackList tracks = new TrackList();
            tracks.setTracks(trackDAO.findTracksFromPlaylist(playlistId));
            return tracks;
        }
        throw new InvalidTokenException(INVALID_TOKEN_MESSAGE);
    }

    public void deleteTrackFromPlaylist(int playlistId, int trackId, String token) throws InvalidTokenException {
        int userId = SessionManager.getInstance().findUserByToken(token).getId();
        int playlistOwnerId = playlistDAO.find(playlistId).getOwnerId();
        if (userId == playlistOwnerId) {
            trackDAO.deleteTrackFromPlaylist(playlistId, trackId);
        }
    }
}
