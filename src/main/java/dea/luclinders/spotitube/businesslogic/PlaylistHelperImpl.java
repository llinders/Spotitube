package dea.luclinders.spotitube.businesslogic;

import dea.luclinders.spotitube.domain.PlaylistList;
import dea.luclinders.spotitube.domain.UserPlaylist;

import java.util.List;

public class PlaylistHelperImpl implements PlaylistHelper {

    public PlaylistList makeOverview(List<UserPlaylist> playlists) {
        int totalLength = 0;
        for (UserPlaylist playlist : playlists) {
            totalLength += playlist.getLength();
        }
        return new PlaylistList(playlists, totalLength);
    }
}
