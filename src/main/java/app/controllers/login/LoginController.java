package app.controllers.login;

import app.dtos.request.LoginRequest;
import app.services.userServices.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
            try{
                return ResponseEntity.ok(loginService.login(loginRequest));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }
}
