package app.services.answer;

import app.dtos.request.AnswerRequest;
import app.models.Answers;
import app.repositories.AnswersRepository;
import app.services.userServices.findUserCurrentLevel.FindCurrentLevelServiceImpl;
import app.services.userServices.nextLevelSetUp.UserNextLevelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswersRepository answersRepository;

    @Autowired
    private FindCurrentLevelServiceImpl findCurrentLevelService;

    @Autowired
    private  UserNextLevelServiceImpl userNextLevelService;


    @Override
    public String checkAnswer(AnswerRequest answerRequest) {
        long currentLevel = findCurrentLevelService.getCurrentLevel(answerRequest.getUserName());
        long startId = 0;
        long endId = 0;

        if(currentLevel == 1){
            startId = 1;
            endId = 10;
        }

        if(currentLevel == 2){
            startId = 11;
            endId = 20;
        }

        if(currentLevel == 3){
            startId = 21;
            endId = 30;
        }

        if(currentLevel == 4){
            startId = 31;
            endId = 40;
        }

        if(currentLevel == 5){
            startId = 41;
            endId = 50;
        }

        if(currentLevel == 6){
            startId = 51;
            endId = 60;
        }
        if(currentLevel == 7){
            startId = 61;
            endId = 70;
        }
        if(currentLevel == 8){
            startId = 71;
            endId = 80;
        }
        if(currentLevel == 9){
            startId = 81;
            endId = 90;
        }
        if(currentLevel == 10){
            startId = 91;
            endId = 100;
        }
        Sort sort = Sort.by(Sort.Order.asc("id"));
        List<Answers> answer = answersRepository.findAnswerOrderedByIdBetween(startId, endId, sort);
       int count = 0;

        System.out.println(answer.toString());

       for(int index = 0; index < answerRequest.getSelectedOptions().size(); index++){
           if(answer.get(index).getAnswer() == null || answer.get(index).getAnswer().equals("")) continue;
//           System.out.println(answerRequest.getSelectedOptions().get(index));
//           System.out.println(answer.get(index).getAnswer());

           if(answer.get(index).getAnswer().equalsIgnoreCase(answerRequest.getSelectedOptions().get(index))){
               count++;
           }
       }

       if(count == 10) {
           userNextLevelService.setNextLevel(answerRequest.getUserName());
           return "Congratulation";
       }
       return "You scored "+count+" out of 10";
    }
}
