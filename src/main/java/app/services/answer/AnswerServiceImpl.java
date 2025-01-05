package app.services.answer;

import app.dtos.request.AnswerRequest;
import app.models.Answers;
import app.repositories.AnswersRepository;
import app.services.userServices.findUserCurrentLevel.FindCurrentLevelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswersRepository answersRepository;

    @Autowired
    private FindCurrentLevelServiceImpl findCurrentLevelService;

    @Override
    public String checkAnswer(AnswerRequest answerRequest) {
        long response = findCurrentLevelService.getCurrentLevel(answerRequest.getUserName());
        Optional<Answers> answersResponse =  answersRepository.findById(response);
       String realAnswer =   answersResponse.get().getAnswer();
       int count = 0;

       if(realAnswer.equalsIgnoreCase(answerRequest.getSelectedOptions()))

        return "Congratulations! You have done well";
       else {
           for(int index= 0; index <= answerRequest.getSelectedOptions().length(); index++) {
               if(realAnswer.charAt(index) == answerRequest.getSelectedOptions().charAt(index)) {
                    count++;
               }
           }
           return "You scored "+ count + " out of 10";
       }
    }
}
