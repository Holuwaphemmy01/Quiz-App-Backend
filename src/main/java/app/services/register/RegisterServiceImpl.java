package app.services.register;


import app.dtos.request.RegisterRequest;
import app.models.Users;
import app.repositories.UsersRepository;
import app.services.password.HashPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private HashPassword hashPassword;


    @Override
    public String register(RegisterRequest registerRequest) {
        fieldValidation(registerRequest);
        emailAndUserExistenceValidation(registerRequest);
        return saveData(registerRequest);
    }










    private String saveData(RegisterRequest registerRequest) {
        Users user = new Users();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setUserName(registerRequest.getUserName());
        user.setPassword(hashPassword.hash(registerRequest.getPassword()));
        user.setCurrentLevel(1);
        Users response =  usersRepository.save(user);
        if (response.getUserName().isBlank()) throw new IllegalArgumentException("ERROR IN CREATING ACCOUNT");
        return "Registered successfully";
    }

    private void emailAndUserExistenceValidation(RegisterRequest registerRequest) {
        if(usersRepository.existsById(registerRequest.getUserName())) throw new IllegalArgumentException("Username already exists");
        if(usersRepository.existsByEmail(registerRequest.getEmail())) throw new IllegalArgumentException("Email already exists");

    }

    private void fieldValidation(RegisterRequest registerRequest) {
        if (registerRequest.getFirstName().isBlank()) throw new IllegalArgumentException("First name cannot be blank");
        if (registerRequest.getLastName().isBlank()) throw new IllegalArgumentException("Last name cannot be blank");
        if (registerRequest.getEmail().isBlank()) throw new IllegalArgumentException("Email cannot be blank");
        if(!registerRequest.getEmail().contains("@") || !registerRequest.getEmail().contains(".")) throw new IllegalArgumentException("Invalid email format");
        if(registerRequest.getPassword().isBlank() || registerRequest.getPassword().length() < 6 || registerRequest.getPassword().length() >16) throw new IllegalArgumentException("Password cannot be blank");
        if(registerRequest.getUserName().isBlank()) throw new IllegalArgumentException("Username cannot be blank");
        if(registerRequest.getUserName().length() < 3) throw new IllegalArgumentException("Username must be at least 3 characters");
        if(registerRequest.getPassword().length() > 10) throw new IllegalArgumentException("Password must not be more than 10 characters");
    }




}
