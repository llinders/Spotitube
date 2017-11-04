package dea.luclinders.spotitube.businesslogic.login;

import dea.luclinders.spotitube.businesslogic.SessionManager;
import dea.luclinders.spotitube.businesslogic.TokenGenerator;
import dea.luclinders.spotitube.dataaccess.dao.user.UserDAO;
import dea.luclinders.spotitube.domain.Session;
import dea.luclinders.spotitube.domain.User;

import javax.inject.Inject;
import javax.security.auth.login.CredentialException;
import javax.ws.rs.NotFoundException;

public class LoginHandlerImpl implements LoginHandler {
    @Inject
    private UserDAO userDAO;
    @Inject
    private TokenGenerator tokenGenerator;
    @Inject
    private SessionManager sessionManager;

    public Session checkCredentials(String username, String password) throws CredentialException {
        try {
            User user = userDAO.findByUsername(username);
            if (user.getPassword().equals(password)) {
                Session session = new Session(tokenGenerator.generateToken(), user);
                sessionManager.addSession(session.getToken(), user);
                return session;
            }
        } catch (NotFoundException e) {
            throw new CredentialException("Invalid credentials");
        }
        throw new CredentialException("Invalid credentials");
    }
}
