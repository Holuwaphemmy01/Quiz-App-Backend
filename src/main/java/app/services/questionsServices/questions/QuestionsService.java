package app.services.questionsServices.questions;


import app.dtos.request.QuestionsRequest;
import app.models.Questions;

import java.util.List;

public interface QuestionsService {
    List<Questions> getAllQuestions(QuestionsRequest questionsRequest);
}
