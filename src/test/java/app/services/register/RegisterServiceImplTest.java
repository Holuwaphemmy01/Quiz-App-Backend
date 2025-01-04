package app.services.register;

import app.dtos.request.RegisterRequest;
import app.repositories.UsersRepository;
import app.services.userServices.register.RegisterServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RegisterServiceImplTest {

    @Autowired
    private RegisterServiceImpl registerServiceImpl;

    @Autowired
    private UsersRepository UsersRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void testThatFirstNameThrowShouldExceptionWhenItIsEmpty() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName(" ");
        assertThrows(IllegalArgumentException.class, () -> registerServiceImpl.register(registerRequest));
    }

    @Test
    public void testThatLastNameThrowShouldExceptionWhenItIsEmpty() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName(" ");
        assertThrows(IllegalArgumentException.class, () -> registerServiceImpl.register(registerRequest));
    }

    @Test
    public void testThatEmailShouldThrowExceptionWhenItIsEmpty() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName("victoria ");
        registerRequest.setEmail(" ");
        assertThrows(IllegalArgumentException.class, () -> registerServiceImpl.register(registerRequest));
    }

    @Test
    public void testThatEmailShouldThrowExceptionWhenIsItInvalid() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName("victoria ");
        registerRequest.setEmail("victoria@gmailcom ");
        assertThrows(IllegalArgumentException.class, () -> registerServiceImpl.register(registerRequest));
    }

    @Test
    public void testThatPasswordShouldThrowExceptionWhenItIsEmpty() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName("victoria ");
        registerRequest.setEmail("victoria@gmail.com");
        registerRequest.setPassword("");
        assertThrows(IllegalArgumentException.class, () -> registerServiceImpl.register(registerRequest));
    }

    @Test
    public void testThatPasswordShouldThrowExceptionWhenPasswordLengthIsLessThan8() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName("victoria ");
        registerRequest.setEmail("victoria@gmail.com");
        registerRequest.setPassword("Oluwi");
        assertThrows(IllegalArgumentException.class, () -> registerServiceImpl.register(registerRequest));
    }

    @Test
    public void testThatPasswordShouldThrowExceptionWhenPasswordLengthIsMoreThan16() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName("victoria ");
        registerRequest.setEmail("victoria@gmail.com");
        registerRequest.setPassword("Oluwjdjdjdjcwkasanaksnknsaknsalknaskncni");
        assertThrows(IllegalArgumentException.class, () -> registerServiceImpl.register(registerRequest));
    }

    @Test
    public void testThatUsernameShouldThrowExceptionWhenItIsEmpty() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName("victoria ");
        registerRequest.setEmail("victoria@gmail.com");
        registerRequest.setPassword("Olnaskncni");
        registerRequest.setUserName("");
        assertThrows(IllegalArgumentException.class, () -> registerServiceImpl.register(registerRequest));
    }


    @Test
    public void testThatUsernameShouldThrowExceptionWhenTheLengthIsLessThan3() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName("victoria ");
        registerRequest.setEmail("victoria@gmail.com");
        registerRequest.setPassword("Olnaskncni");
        registerRequest.setUserName("hd");
        assertThrows(IllegalArgumentException.class, () -> registerServiceImpl.register(registerRequest));
    }

    @Test
    public void testThatUsernameShouldThrowExceptionWhenTheLengthIsMoreThan10() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName("victoria ");
        registerRequest.setEmail("victoria@gmail.com");
        registerRequest.setPassword("Olnaskncni");
        registerRequest.setUserName("hdhysdsdiasaskasklsalk");
        assertThrows(IllegalArgumentException.class, () -> registerServiceImpl.register(registerRequest));
    }


    @Test
    public void testToRegisterUserSuccessfullyAndUserRepositoryWillBeOne(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName("victoria ");
        registerRequest.setEmail("victoria@gmail.com");
        registerRequest.setPassword("Oluwafemi");
        registerRequest.setUserName("Femzzy");
        String response = registerServiceImpl.register(registerRequest);
        assertNotNull(response);
        assertEquals( 1, usersRepository.count());
    }


    @Test
    public void testNotToRegisterUserWithExistingUserName(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName("victoria ");
        registerRequest.setEmail("victoria@gmail.com");
        registerRequest.setPassword("Oluwafemi");
        registerRequest.setUserName("Remilekun");
        registerServiceImpl.register(registerRequest);
        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setFirstName("femi");
        registerRequest1.setLastName("victoria ");
        registerRequest1.setEmail("victoria@gmail.com");
        registerRequest1.setPassword("Oluwafemi");
        registerRequest1.setUserName("Remilekun");
        assertThrows(IllegalArgumentException.class, () ->  registerServiceImpl.register(registerRequest1));
    }


    @Test
    public void testNotToRegisterUserWithExistingEmailAddress(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("femi");
        registerRequest.setLastName("victoria ");
        registerRequest.setEmail("victor@gmail.com");
        registerRequest.setPassword("Oluwafemi");
        registerRequest.setUserName("Remilekun000");
        registerServiceImpl.register(registerRequest);
        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setFirstName("femi");
        registerRequest1.setLastName("victoria ");
        registerRequest1.setEmail("victor@gmail.com");
        registerRequest1.setPassword("Oluwafemi");
        registerRequest1.setUserName("Remilekun01");
        assertThrows(IllegalArgumentException.class, () ->  registerServiceImpl.register(registerRequest1));
    }

}