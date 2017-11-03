package dea.luclinders.spotitube.services.rest;

import dea.luclinders.spotitube.domain.LoginRequest;

import javax.ws.rs.core.Response;

public interface UserRestService {

    Response getTokenByUsernameAndPassword(LoginRequest loginRequest);

}
