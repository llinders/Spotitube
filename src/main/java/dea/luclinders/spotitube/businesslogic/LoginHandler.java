package dea.luclinders.spotitube.businesslogic;

import dea.luclinders.spotitube.domain.Session;

import javax.security.auth.login.CredentialException;

public interface LoginHandler {

    Session checkCredentials(String username, String password) throws CredentialException;

}
