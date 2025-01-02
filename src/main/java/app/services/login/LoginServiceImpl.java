package app.services.login;

import app.dtos.request.LoginRequest;
import app.dtos.response.LoginResponse;
import app.models.Users;
import app.repositories.UsersRepository;
import app.services.password.HashPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private HashPassword hashPassword;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        fieldValidation(loginRequest);
        return dataVerification(loginRequest);
    }









    private void fieldValidation(LoginRequest loginRequest) {
        if(loginRequest.getUsername() == null || loginRequest.getPassword() == null) throw new IllegalArgumentException("field cannot be null");
        if(loginRequest.getUsername().isEmpty() || loginRequest.getPassword().isEmpty()) throw new IllegalArgumentException("field cannot be empty");
        if(loginRequest.getUsername().isBlank() || loginRequest.getPassword().isBlank()) throw new IllegalArgumentException("field cannot be empty");
    }

    private LoginResponse dataVerification(LoginRequest loginRequest) {
        Users response = usersRepository.findByUserName(loginRequest.getUsername());
        if(response == null) throw new IllegalArgumentException("user not found");

        if(!hashPassword.checkPassword(loginRequest.getPassword(), response.getPassword())) throw new IllegalArgumentException("wrong password");
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserName(response.getUserName());
        loginResponse.setCurrentLevel(response.getCurrentLevel());
        return loginResponse;

    }
}
