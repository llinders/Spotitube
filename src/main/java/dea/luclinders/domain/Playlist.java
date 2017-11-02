package dea.luclinders.domain;

import java.util.ArrayList;

public class Playlist {
    private int id;
    private String name;
    private ArrayList<Track> tracks;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }
}
