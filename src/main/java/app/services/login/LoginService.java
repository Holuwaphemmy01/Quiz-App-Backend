package app.services.login;

import app.dtos.request.LoginRequest;

public interface LoginService {
    String login(LoginRequest loginRequest);
}
