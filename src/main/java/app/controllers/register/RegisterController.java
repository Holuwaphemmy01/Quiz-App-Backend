package app.controllers.register;

import app.dtos.request.RegisterRequest;
import app.models.Users;
import app.repositories.UsersRepository;
import app.services.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        try{
            return registerService.register(registerRequest);
        }catch (Exception e){
            return e.getMessage();
        }
    }



}
