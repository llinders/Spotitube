package dea.luclinders.domain;

import java.util.ArrayList;

public class Playlist {
    private int id;
    private String name;
    private ArrayList<Track> tracks;

    public Playlist(int id, String name, ArrayList<Track> tracks) {
        this.id = id;
        this.name = name;
        this.tracks = tracks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }
}
