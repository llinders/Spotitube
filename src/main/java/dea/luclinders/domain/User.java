package dea.luclinders.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
//    private int id;
//    private String firstname;
//    private String lastname;
    private String username;
    private String password;

    /*public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }*/

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
