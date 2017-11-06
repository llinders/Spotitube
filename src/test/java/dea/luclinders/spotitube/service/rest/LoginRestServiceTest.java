package dea.luclinders.spotitube.service.rest;

import dea.luclinders.spotitube.businesslogic.LoginHandler;
import dea.luclinders.spotitube.domain.LoginRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.security.auth.login.CredentialException;

import static org.mockito.Mockito.verify;

public class LoginRestServiceTest {
    @Mock
    private LoginHandler loginHandler;
    @InjectMocks
    private LoginRestService loginService;

    private LoginRequest loginRequest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        loginRequest = new LoginRequest();
        loginRequest.setUser("username");
        loginRequest.setPassword("password");
    }

    @Test
    public void getTokenByUsernameAndPassword_shouldCallCheckCredentials() throws CredentialException {
        // Test
        loginService.getTokenByUsernameAndPassword(loginRequest);

        // Verify
        verify(loginHandler).checkCredentials(loginRequest.getUser(), loginRequest.getPassword());
    }
}