package dea.luclinders.spotitube.businesslogic.login;

import dea.luclinders.spotitube.businesslogic.SessionManager;
import dea.luclinders.spotitube.businesslogic.TokenGenerator;
import dea.luclinders.spotitube.dataaccess.dao.user.UserDAO;
import dea.luclinders.spotitube.domain.Session;
import dea.luclinders.spotitube.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.security.auth.login.CredentialException;
import javax.ws.rs.NotFoundException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LoginHandlerImplTest {
    @Mock
    private UserDAO userDAO;
    @Mock
    private TokenGenerator tokenGenerator;
    @Mock
    private SessionManager sessionManager;
    @InjectMocks
    private LoginHandlerImpl loginHandler;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkCredentials_shouldReturnSessionWithToken() throws CredentialException {
        // Setup
        String username = "username";
        String password = "password";
        String token = "1234-1234-1234";

        User user = new User();
        user.setUser(username);
        user.setPassword(password);

        when(userDAO.findByUsername(username)).thenReturn(user);
        when(tokenGenerator.generateToken()).thenReturn(token);

        // Test
        Session session = loginHandler.checkCredentials(username, password);

        // Verify
        assertEquals(token, session.getToken());
    }

    @Test(expected = CredentialException.class)
    public void checkCredentials_shouldThrowCredentialExceptionWhenUserNotFound() throws CredentialException {
        // Setup
        String username = "username";
        String password = "password";

        when(userDAO.findByUsername(username)).thenThrow(NotFoundException.class);

        // Test
        loginHandler.checkCredentials(username, password);
    }
}