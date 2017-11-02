package dea.luclinders.domain;

import java.util.ArrayList;

public class Playlist {
    private int id;
    private String name;
    private boolean owner;
    private ArrayList<Track> tracks;
    private transient int length;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public int getLength() {
        return length;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
