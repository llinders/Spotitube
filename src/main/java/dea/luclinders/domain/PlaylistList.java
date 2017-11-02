package dea.luclinders.domain;

import java.util.List;

public class PlaylistList {
    private List<Playlist> playlists;
    private int length;

    public PlaylistList(List<Playlist> playlists, int length) {
        this.playlists = playlists;
        this.length = length;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public int getLength() {
        return length;
    }
}
