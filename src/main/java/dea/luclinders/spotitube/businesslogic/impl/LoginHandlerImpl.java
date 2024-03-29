package dea.luclinders.spotitube.businesslogic.impl;

import dea.luclinders.spotitube.businesslogic.LoginHandler;
import dea.luclinders.spotitube.businesslogic.session.SessionManager;
import dea.luclinders.spotitube.businesslogic.session.TokenGenerator;
import dea.luclinders.spotitube.dataaccess.dao.UserDAO;
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

    public Session checkCredentials(String username, String password) throws CredentialException {
        try {
            User user = userDAO.findByUsername(username);
            if (user.getPassword().equals(password)) {
                Session session = new Session(tokenGenerator.generateToken(), user);
                SessionManager.getInstance().addSession(session.getToken(), user);
                return session;
            }
        } catch (NotFoundException e) {
            throw new CredentialException("Invalid credentials");
        }
        throw new CredentialException("Invalid credentials");
    }
}
