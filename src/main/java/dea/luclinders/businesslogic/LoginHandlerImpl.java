package dea.luclinders.businesslogic;

import dea.luclinders.dataaccess.dao.user.UserDAO;
import dea.luclinders.domain.Session;
import dea.luclinders.domain.User;

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
