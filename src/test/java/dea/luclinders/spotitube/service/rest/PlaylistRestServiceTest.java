package dea.luclinders.spotitube.service.rest;

import dea.luclinders.spotitube.businesslogic.PlaylistHandler;
import dea.luclinders.spotitube.businesslogic.session.InvalidTokenException;
import dea.luclinders.spotitube.domain.UserPlaylist;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class PlaylistRestServiceTest {
    @Mock
    private PlaylistHandler playlistHandler;
    @InjectMocks
    private PlaylistRestService playlistService;

    private final String TOKEN = "1234-1234-1234";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllAvailablePlaylists_shouldCallFindAllAvailablePlaylists() throws InvalidTokenException {
        // Test
        playlistService.getAllAvailablePlaylists(TOKEN);

        // Verify
        verify(playlistHandler).findAllAvailablePlaylists(TOKEN);
    }

    @Test
    public void addPlaylist_shouldCallCreatePlaylist() throws InvalidTokenException {
        // Setup
        UserPlaylist playlist = new UserPlaylist();
        playlist.setName("playlist");

        // Test
        playlistService.addPlaylist(playlist, TOKEN);

        // Verify
        verify(playlistHandler).createPlaylist(playlist.getName(), TOKEN);
    }

    @Test
    public void addPlaylist_shouldCallFindAllAvailablePlaylists() throws InvalidTokenException {
        // Test
        playlistService.getAllAvailablePlaylists(TOKEN);

        // Verify
        verify(playlistHandler).findAllAvailablePlaylists(TOKEN);
    }

    @Test
    public void editPlaylist_shouldCallUpdatePlaylist() throws InvalidTokenException {
        // Setup
        UserPlaylist playlist = new UserPlaylist();
        playlist.setId(1);
        playlist.setName("playlist");

        // Test
        playlistService.editPlaylist(playlist, playlist.getId(), TOKEN);

        // Verify
        verify(playlistHandler).updatePlaylist(playlist.getId(), playlist.getName(), TOKEN);
    }

    @Test
    public void deletePlaylist_shouldCallDeletePlaylist() throws InvalidTokenException {
        // Setup
        UserPlaylist playlist = new UserPlaylist();
        playlist.setId(1);

        // Test
        playlistService.deletePlaylist(playlist.getId(), TOKEN);

        // Verify
        verify(playlistHandler).deletePlaylist(playlist.getId(), TOKEN);
    }
}