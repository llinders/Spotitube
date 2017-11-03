package dea.luclinders.spotitube.domain;

import java.util.ArrayList;

public class Playlist {
    private int id;
    private String name;
    private int ownerId;
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

    public int getLength() {
        return length;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
