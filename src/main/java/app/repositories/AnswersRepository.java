package app.repositories;

import app.models.Answers;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswersRepository extends JpaRepository<Answers, Long> {
    List<Answers> findAnswerOrderedByIdBetween(long startId, long endId, Sort sort);
}
