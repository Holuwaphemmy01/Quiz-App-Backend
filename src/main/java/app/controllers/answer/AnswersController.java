package app.controllers.answer;


import app.dtos.request.AnswerRequest;
import app.services.answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class AnswersController {

    @Autowired
    private AnswerService answerService;

    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<?> getAnswer(@RequestBody AnswerRequest answerRequest) {
        try{
            return ResponseEntity.ok(answerService.checkAnswer(answerRequest));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
