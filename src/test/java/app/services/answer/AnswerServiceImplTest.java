package app.services.answer;

import app.dtos.request.AnswerRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AnswerServiceImplTest {

    @Autowired
    private AnswerService answerService;


    @Test
    public void testToThrowExceptionWhenInvalidUserNAmeIsPAssed(){
        AnswerRequest answerRequest = new AnswerRequest();
        answerRequest.setUserName("hdhdhdh");
        answerRequest.setSelectedOptions("affafafafaf");
        assertThrows(IllegalArgumentException.class, () -> answerService.checkAnswer(answerRequest));
    }

    @Test
    public void testToPassWrongOptionsAtLevelOneAndTheCurrentLevelWillStillBeTheSame(){
        AnswerRequest answerRequest = new AnswerRequest();
        answerRequest.setUserName("Akinzo");
        answerRequest.setSelectedOptions("abcacddacba");
        String response = answerService.checkAnswer(answerRequest);
        System.out.println(response);

    }
}