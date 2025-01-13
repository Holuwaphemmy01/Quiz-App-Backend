package app.services.answer;

import app.dtos.request.AnswerRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AnswerServiceImplTest {

    @Autowired
    private AnswerService answerService;


//    @Test
//    public void testToThrowExceptionWhenInvalidUserNAmeIsPAssed(){
//        AnswerRequest answerRequest = new AnswerRequest();
//        answerRequest.setUserName("hdhdhdh");
//        answerRequest.setSelectedOptions("affafafafaf");
//        assertThrows(IllegalArgumentException.class, () -> answerService.checkAnswer(answerRequest));
//    }
//
//    @Test
//    public void testToPassWrongOptionsAtLevelOneAndTheCurrentLevelWillStillBeTheSame(){
//        AnswerRequest answerRequest = new AnswerRequest();
//        answerRequest.setUserName("Akinzo");
//        answerRequest.setSelectedOptions("abcacddcaa");
//        String response = answerService.checkAnswer(answerRequest);
//        System.out.println(response);
//
//    }

    @Test
    public void testToPassWrongOptionsAtLevelOelWillStillBeTheSame(){
        AnswerRequest answerRequest = new AnswerRequest();
        answerRequest.setUserName("o-jacob");
        ArrayList<String> answer = new ArrayList<>();
        answer.add("JavaScript XML");
        answer.add("All of the above");
        answer.add("append()");
        answer.add("<ul>");
        answer.add("Both value and type");
        answer.add("System.out.println(\"Hello, World!\");");
        answer.add("55");
        answer.add("fetch()");
        answer.add("def");
        answer.add("8");
        answerRequest.setSelectedOptions(answer);
        String response = answerService.checkAnswer(answerRequest);
        System.out.println(response.toString());

    }
}