package app.services.questionsServices.questions;

import app.models.Questions;
import app.repositories.QuestionsRepository;
import app.services.userServices.findUser.FindUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private FindUserServiceImpl findUserService;


    @Override
    public List<Questions> getAllQuestions(String username) {
        if (username == null) throw new IllegalArgumentException("field is empty");
        if (username.isBlank()) throw new IllegalArgumentException("field is empty");

       long currentLevel = findUserService.findUserByUserName(username);
       long startQuestions = 0;
       long endQuestions = 0;


       if(currentLevel == 1){
           startQuestions = 1;
           endQuestions = 10;
       }

       if(currentLevel == 2){
           startQuestions = 11;
           endQuestions = 20;
       }

        if(currentLevel == 3){
            startQuestions = 21;
            endQuestions = 30;
        }

        if(currentLevel == 4){
            startQuestions = 31;
            endQuestions = 40;
        }

        if(currentLevel == 5){
            startQuestions = 41;
            endQuestions = 50;
        }

        if(currentLevel == 6){
            startQuestions = 51;
            endQuestions = 60;
        }
        if(currentLevel == 7){
            startQuestions = 61;
            endQuestions = 70;
        }
        if(currentLevel == 8){
            startQuestions = 71;
            endQuestions = 80;
        }
        if(currentLevel == 9){
            startQuestions = 81;
            endQuestions = 90;
        }
        if(currentLevel == 10){
            startQuestions = 91;
            endQuestions = 100;
        }


        return questionsRepository.findByIdBetween(startQuestions, endQuestions);
    }

}
