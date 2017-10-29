package dea.luclinders.domain;

public abstract class Track {
    protected String title;
    protected String performer;
    protected String url;
    protected int duration;

    public Track(String performer, String title, String url, int duration) {
        this.performer = performer;
        this.title = title;
        this.url = url;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getPerformer() {
        return performer;
    }

    public String getUrl() {
        return url;
    }

    public int getDuration() {
        return duration;
    }
}
