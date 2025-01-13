package app.controllers.login;

import app.dtos.request.LoginRequest;
import app.services.userServices.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @CrossOrigin("*")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
            try{
                return ResponseEntity.ok(loginService.login(loginRequest));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
    }
}
