package dea.luclinders.services.rest;

import dea.luclinders.businesslogic.TokenGeneratorImpl;
import dea.luclinders.dataaccess.dao.user.UserDAO;
import dea.luclinders.domain.LoginRequest;
import dea.luclinders.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserRestServiceTest {
    @Mock
    private UserDAO userDAO;
    @Mock
    private TokenGeneratorImpl tokenGenerator;
    @InjectMocks
    private UserRestServiceImpl userService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userService = new UserRestServiceImpl();
    }

    @Test
    public void getTokenByUsernameAndPassword() {
        // Setup
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUser("username");
        loginRequest.setPassword("password");

//        when(userDAO.findByUsername("username")).thenReturn(loginRequest);
        when(tokenGenerator.generateToken()).thenReturn("1234-1234-1234");

        // Test
        Response response = userService.getTokenByUsernameAndPassword(loginRequest);

        // Verify
        assertThat(response.getEntity(), is(""));
    }
}