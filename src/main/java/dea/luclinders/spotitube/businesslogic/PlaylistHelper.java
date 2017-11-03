package dea.luclinders.spotitube.businesslogic;

import dea.luclinders.spotitube.domain.Playlist;
import dea.luclinders.spotitube.domain.PlaylistList;

import java.util.List;

public interface PlaylistHelper {

    PlaylistList makeOverview(List<Playlist> playlists);

}
