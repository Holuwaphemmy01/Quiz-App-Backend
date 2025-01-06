package app.controllers.register;

import app.dtos.request.RegisterRequest;
import app.repositories.UsersRepository;
import app.services.userServices.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        try{
            return ResponseEntity.ok( registerService.register(registerRequest));
        }catch (Exception e){
          return   ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
