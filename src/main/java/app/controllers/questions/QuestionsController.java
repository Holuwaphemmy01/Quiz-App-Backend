package app.controllers.questions;

import app.dtos.request.QuestionsRequest;
import app.services.questionsServices.questions.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;


    @CrossOrigin("*")
    @GetMapping("/questions/{username}")
    public ResponseEntity<?> getQuestions(@PathVariable("username") String username) {
        try{
            return ResponseEntity.ok(questionsService.getAllQuestions(username));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
