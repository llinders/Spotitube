package dea.luclinders.spotitube.businesslogic;

import dea.luclinders.spotitube.domain.PlaylistList;
import dea.luclinders.spotitube.domain.UserPlaylist;

import java.util.List;

public interface PlaylistHelper {

    PlaylistList makeOverview(List<UserPlaylist> playlists);

}
