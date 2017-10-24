package dea.luclinders.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private String username;
    private String password;

    @XmlElement(name = "user")
    public String getUsername() {
        return username;
    }

    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }

    public boolean isValidUser() {
        return false;
    }
}
