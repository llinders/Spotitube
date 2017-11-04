package dea.luclinders.spotitube.businesslogic;

import dea.luclinders.spotitube.dataaccess.dao.playlist.PlaylistDAO;

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
