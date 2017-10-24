package dea.luclinders.domain;

public class Token {
    private String token;
    private User user;

    public String getToken() {
        return token;
    }

    public String getFullname() {
        return user.getFirstname() + " " + user.getLastname();
    }
}
