package app.services.questionsServices.questions;


import app.dtos.request.QuestionsRequest;
import app.models.Questions;
import app.repositories.QuestionsRepository;
import app.services.userServices.findUser.FindUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private FindUserServiceImpl findUserService;


    @Override
    public List<Questions> getAllQuestions(QuestionsRequest questionsRequest) {
        if (questionsRequest == null) throw new IllegalArgumentException("field is empty");
        if (questionsRequest.getUserName().isBlank()) throw new IllegalArgumentException("field is empty");

       long currentLevel = findUserService.findUserByUserName(questionsRequest.getUserName());
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



        List<Questions> questionsList = new ArrayList<>();
       for(long count = startQuestions; count <= endQuestions; count++) {
           Optional<Questions> questions = questionsRepository.findById(count);
           if(questions.isPresent()) questionsList.add(questions.get());
       }
        return questionsList;
    }

}
