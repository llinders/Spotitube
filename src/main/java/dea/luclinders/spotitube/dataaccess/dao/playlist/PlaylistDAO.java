package dea.luclinders.spotitube.dataaccess.dao.playlist;

import dea.luclinders.spotitube.domain.Playlist;

import java.util.List;

public interface PlaylistDAO {

    List<Playlist> findAll();

    Playlist find(int playlistId);

    void create(Playlist playlist);

    void update(Playlist playlist);

}
