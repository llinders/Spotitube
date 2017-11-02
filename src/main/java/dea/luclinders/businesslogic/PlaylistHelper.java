package dea.luclinders.businesslogic;

import dea.luclinders.domain.Playlist;
import dea.luclinders.domain.PlaylistList;

import java.util.List;

public interface PlaylistHelper {

    PlaylistList makeOverview(List<Playlist> playlists);

}
