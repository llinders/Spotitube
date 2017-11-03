package dea.luclinders.businesslogic;

import dea.luclinders.domain.Session;

import javax.security.auth.login.CredentialException;

public interface LoginHandler {

    Session checkCredentials(String username, String password) throws CredentialException;

}
