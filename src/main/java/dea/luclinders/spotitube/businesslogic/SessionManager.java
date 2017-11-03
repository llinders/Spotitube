package dea.luclinders.spotitube.businesslogic;

import dea.luclinders.spotitube.domain.User;

import java.util.HashMap;

public class SessionManager {
    private static SessionManager instance;
    private HashMap<String, User> sessions;

    private SessionManager() {
        sessions = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public User findUserByToken(String token) throws InvalidTokenException {
        User user = sessions.get(token);
        if (user == null) {
            throw new InvalidTokenException("Invalid token");
        }
        return user;
    }

    public void addSession(String token, User user) {
        sessions.put(token, user);
    }

    public boolean isValid(String token) {
        return sessions.get(token) != null;
    }
}
