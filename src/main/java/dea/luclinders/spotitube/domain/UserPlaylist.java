package dea.luclinders.spotitube.domain;

import java.util.ArrayList;

public class UserPlaylist {
    private int id;
    private String name;
    private boolean owner;
    private ArrayList<Track> tracks;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isOwner() {
        return owner;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }
}
