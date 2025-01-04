package app.services.answer;

import app.dtos.request.AnswerRequest;
import app.repositories.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswersRepository answersRepository;

    @Override
    public String checkAnswer(AnswerRequest answerRequest) {

        return "";
    }
}
