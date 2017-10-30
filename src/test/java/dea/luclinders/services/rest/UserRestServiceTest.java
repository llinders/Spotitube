package dea.luclinders.services.rest;

import dea.luclinders.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserRestServiceTest {
    private UserRestService userService;

    @Before
    public void setup() {
        userService = new UserRestServiceImpl();
    }

    @Test
    public void getTokenByUsernameAndPassword() {
        // init
        User u = mock(User.class);
        when(u.getUser()).thenReturn("username");
        when(u.getPassword()).thenReturn("password");

        // test
        userService.getTokenByUsernameAndPassword(u);

        // verify

    }
}