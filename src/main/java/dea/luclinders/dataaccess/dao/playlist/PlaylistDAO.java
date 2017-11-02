package dea.luclinders.dataaccess.dao.playlist;

import dea.luclinders.dataaccess.dao.DAO;
import dea.luclinders.domain.Playlist;

import java.util.List;

public interface PlaylistDAO extends DAO<Playlist> {

    List<Playlist> findAll();

}
