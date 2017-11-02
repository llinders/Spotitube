package dea.luclinders.domain;

public class Token {
    private String token;
    private transient User user;

    public Token(String token, User user) {
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
