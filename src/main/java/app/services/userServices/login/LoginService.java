package app.services.userServices.login;

import app.dtos.request.LoginRequest;
import app.dtos.response.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
}
