package dea.luclinders.spotitube.domain;

public class Session {
    private String token;
    private transient User user;

    public Session(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public String getUser() {
        return user.getFirstname() + " " + user.getLastname();
    }
}
