package app.controllers.questions;

import app.dtos.request.QuestionsRequest;
import app.services.questionsServices.questions.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @PostMapping("/questions")
    public ResponseEntity<?> getQuestions(@RequestBody QuestionsRequest questionsRequest) {
        try{
            return ResponseEntity.ok(questionsService.getAllQuestions(questionsRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
