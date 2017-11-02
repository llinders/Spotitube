package dea.luclinders.dataaccess.dao.playlist;

import dea.luclinders.domain.Playlist;

import java.util.List;

public interface PlaylistDAO {

    List<Playlist> findAll(int userId);

}
