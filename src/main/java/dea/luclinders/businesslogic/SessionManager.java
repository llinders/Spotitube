package dea.luclinders.businesslogic;

import dea.luclinders.domain.User;

import java.util.HashMap;

public class SessionManager {
    private static SessionManager instance;
    private HashMap<String, User> sessions;

    private SessionManager() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public User findUserByToken(String token) {
        return sessions.get(token);
    }

    public void addSession(String token, User user) {
        sessions.put(token, user);
    }
}
