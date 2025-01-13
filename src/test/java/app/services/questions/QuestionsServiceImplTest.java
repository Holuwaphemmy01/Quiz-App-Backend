package app.services.questions;

import app.dtos.request.QuestionsRequest;
import app.models.Questions;
import app.repositories.QuestionsRepository;
import app.services.questionsServices.questions.QuestionsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class QuestionsServiceImplTest {

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private QuestionsRepository questionsRepository;

    @Test
    public void testToGetQuestionsFrom1to10() {
        List<Questions> response =  questionsService.getAllQuestions("o-jacob");
        System.out.println(response.toString());
        assertEquals(10, response.size());
    }


//    @Test
//    public void testToGetQu() {
//        Questions questions = new Questions();
//        questions.setId(101);
//        questions.setQuestion("who are you?");
//        questions.setOptions(List.of("one", "two", "three"));
//        Optional<Questions> response = questionsRepository.findById(Long.valueOf(1));
//        System.out.println(response.toString());
//
//    }
}