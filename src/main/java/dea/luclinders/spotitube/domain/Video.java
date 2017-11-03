package dea.luclinders.spotitube.domain;

import java.util.Date;

public class Video {
    private Date publicationDate;
    private String description;

    public Video(Date publicationDate, String description) {
        this.publicationDate = publicationDate;
        this.description = description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getDescription() {
        return description;
    }
}
