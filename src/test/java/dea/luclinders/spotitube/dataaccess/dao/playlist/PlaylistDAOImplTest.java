package dea.luclinders.spotitube.dataaccess.dao.playlist;

import dea.luclinders.spotitube.domain.Playlist;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;

public class PlaylistDAOImplTest {
    @InjectMocks
    private PlaylistDAOImpl playlistDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create_shouldCreateNewPlaylist() {
        // Setup
        int playlistId = 1;
        Playlist playlist = new Playlist();
        playlist.setName("playlist");
        playlist.setId(playlistId);
        playlist.setOwnerId(1);

        // Test
        playlistDAO.create(playlist);

        // Verify
        assertEquals(playlist, playlistDAO.find(playlistId));
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}