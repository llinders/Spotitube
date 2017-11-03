package dea.luclinders.spotitube.businesslogic.track;

import dea.luclinders.spotitube.businesslogic.InvalidTokenException;
import dea.luclinders.spotitube.domain.TrackList;

public interface TrackHandler {

    TrackList findAllAvailableTracksNotInPlaylist(int playlistId, String token) throws InvalidTokenException;

    TrackList findAllTracksFromPlaylist(int playlistId, String token) throws InvalidTokenException;

}