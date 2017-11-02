package dea.luclinders.services.rest;

import dea.luclinders.businesslogic.TokenGenerator;
import dea.luclinders.dataaccess.dao.user.UserDAO;
import dea.luclinders.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRestServiceTest {
    private UserRestServiceImpl userService;
    @Mock
    private UserDAO userDAO;
    @Mock
    private TokenGenerator tokenGenerator;

    @Before
    public void setup() {
        userService = new UserRestServiceImpl();
    }

    @Test
    public void getTokenByUsernameAndPassword() {
        // Setup
        User u = new User();
        u.setUser("username");
        u.setPassword("password");

        when(userDAO.findByUsernameAndPassword("username", "password")).thenReturn(u);
        when(tokenGenerator.generateToken()).thenReturn("1234-1234-1234");

        // Test
        Response response = userService.getTokenByUsernameAndPassword(u);

        // Verify
        assertThat(response.getEntity(), is(""));
    }
}