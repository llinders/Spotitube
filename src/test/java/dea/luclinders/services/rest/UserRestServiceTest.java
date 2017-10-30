package dea.luclinders.services.rest;

import dea.luclinders.domain.User;
import dea.luclinders.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserRestServiceTest {
    private UserService userService;

    @Before
    public void setup() {
        userService = new UserRestService();
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