package dea.luclinders.spotitube.domain;

import java.util.Date;

public class Track {
    private int id;
    private String title;
    private String performer;
    private int duration;
    private String album;
    private int playcount;
    private String description;
    private Date publicationDate;
    private boolean offlineAvailable;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPerformer() {
        return performer;
    }

    public int getDuration() {
        return duration;
    }

    public String getAlbum() {
        return album;
    }

    public int getPlaycount() {
        return playcount;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public boolean isOfflineAvailable() {
        return offlineAvailable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setOfflineAvailable(boolean offlineAvailable) {
        this.offlineAvailable = offlineAvailable;
    }
}
