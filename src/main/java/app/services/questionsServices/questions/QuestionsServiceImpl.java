package app.services.questionsServices.questions;


import app.dtos.request.QuestionsRequest;
import app.models.Questions;
import app.models.Users;
import app.repositories.QuestionsRepository;
import app.repositories.UsersRepository;
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
    private UsersRepository usersRepository;


    @Override
    public List<Questions> getAllQuestions(QuestionsRequest questionsRequest) {
        if (questionsRequest == null) throw new IllegalArgumentException("field is empty");
        if (questionsRequest.getUserName().isBlank()) throw new IllegalArgumentException("field is empty");

        Users response = usersRepository.findByUserName(questionsRequest.getUserName());
       int currentLevel = response.getCurrentLevel();
       int startQuestions = 0;
       int endQuestions = 0;


       for(int count =1; count < 11; count++) {
           if(count == currentLevel) {
               startQuestions = currentLevel;
               endQuestions = currentLevel + 9;
           }
       }

        List<Questions> questionsList = new ArrayList<>();
       for(long count = startQuestions; count <= endQuestions; count++) {
           Optional<Questions> questions = questionsRepository.findById(count);
           System.out.println(questions.get().getQuestion());
           if(questions.isPresent()) questionsList.add(questions.get());
       }
        return questionsList;
    }

    @Override
    public void addQuestion(Questions questions) {
        questionsRepository.save(questions);
    }
}
