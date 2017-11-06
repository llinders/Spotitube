package dea.luclinders.spotitube.businesslogic.helper;

import dea.luclinders.spotitube.businesslogic.session.InvalidTokenException;
import dea.luclinders.spotitube.businesslogic.session.SessionManager;
import dea.luclinders.spotitube.dataaccess.dao.PlaylistDAO;

import javax.inject.Inject;

public class PermissionHelper {
    @Inject
    private PlaylistDAO playlistDAO;

    public boolean userIsOwnerOfPlaylist(int userId, int playlistId) {
        return userId == playlistDAO.find(playlistId).getOwnerId();
    }

    public boolean userIsOwnerOfPlaylist(String token, int playlistId) throws InvalidTokenException {
        return userIsOwnerOfPlaylist(SessionManager.getInstance().findUserByToken(token).getId(), playlistId);
    }
}
