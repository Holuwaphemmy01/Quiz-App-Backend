package app.services.login;

import app.dtos.request.LoginRequest;
import app.dtos.response.LoginResponse;
import app.services.userServices.login.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LoginServiceImplTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void testThatWhenUserNameIsEmptyExceptionShouldBeThrown() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("");
        assertThrows(IllegalArgumentException.class, () -> loginService.login(loginRequest));
    }

    @Test
    public void testThatWhenPasswordIsEmptyExceptionShouldBeThrown() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Femmma");
        loginRequest.setPassword("");
        assertThrows(IllegalArgumentException.class, () -> loginService.login(loginRequest));
    }

    @Test
    public void testThatWhenWrongUsernameIsPassedExceptionShouldBeThrown() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Femma");
        loginRequest.setPassword("Oluwafemi");
        assertThrows(IllegalArgumentException.class, () -> loginService.login(loginRequest));
    }

    @Test
    public void testThatWhenWrongPasswordIsPassedExceptionShouldBeThrown() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Fammo");
        loginRequest.setPassword("Oluwafkaka");
        assertThrows(IllegalArgumentException.class, () -> loginService.login(loginRequest));
    }

    @Test
    public void testToReturnUsernameWhenCorrectUsernameAndPasswordIsPassed() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Fammo");
        loginRequest.setPassword("Oluwafemi");
        LoginResponse response = loginService.login(loginRequest);
        assertEquals("Fammo", response.getUserName());
    }


}