package dea.luclinders.spotitube.domain;

import java.util.List;

public class PlaylistList {
    private List<UserPlaylist> playlists;
    private int length;

    public PlaylistList(List<UserPlaylist> playlists, int length) {
        this.playlists = playlists;
        this.length = length;
    }

    public List<UserPlaylist> getPlaylists() {
        return playlists;
    }

    public int getLength() {
        return length;
    }
}
