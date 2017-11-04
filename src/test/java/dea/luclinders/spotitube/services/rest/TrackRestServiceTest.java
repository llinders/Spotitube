package dea.luclinders.spotitube.services.rest;

import dea.luclinders.spotitube.businesslogic.InvalidTokenException;
import dea.luclinders.spotitube.businesslogic.track.TrackHandler;
import dea.luclinders.spotitube.domain.UserPlaylist;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class TrackRestServiceTest {
    @Mock
    private TrackHandler trackHandler;
    @InjectMocks
    private TrackRestService trackService;

    private final String TOKEN = "1234-1234-1234";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllAvailableTracksForPlaylist_shouldCallFindAllAvailableTracksNotInPlaylist() throws InvalidTokenException {
        // Setup
        UserPlaylist playlist = new UserPlaylist();
        playlist.setId(1);

        // Test
        trackService.getAllAvailableTracksForPlaylist(playlist.getId(), TOKEN);

        // Verify
        verify(trackHandler).findAllAvailableTracksNotInPlaylist(playlist.getId(), TOKEN);
    }
}