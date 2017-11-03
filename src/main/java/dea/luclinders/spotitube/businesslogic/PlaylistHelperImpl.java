package dea.luclinders.spotitube.businesslogic;

import dea.luclinders.spotitube.domain.Playlist;
import dea.luclinders.spotitube.domain.PlaylistList;

import java.util.List;

public class PlaylistHelperImpl implements PlaylistHelper {

    public PlaylistList makeOverview(List<Playlist> playlists) {
        int totalLength = 0;
        for (Playlist playlist : playlists) {
            totalLength += playlist.getLength();
        }
        return new PlaylistList(playlists, totalLength);
    }
}
