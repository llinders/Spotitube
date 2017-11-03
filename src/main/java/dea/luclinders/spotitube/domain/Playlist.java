package dea.luclinders.spotitube.domain;

import java.util.ArrayList;

public class Playlist {
    private int id;
    private String name;
    private boolean owner;
    private int ownerId;
    private ArrayList<Track> tracks;
    private int length;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOwnerId() {
        return ownerId;
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

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
