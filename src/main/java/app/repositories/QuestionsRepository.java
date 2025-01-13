package app.repositories;

import app.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    List<Questions> findByIdBetween(Long startId, Long endId);
}
