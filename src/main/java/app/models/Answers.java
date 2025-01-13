package app.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "answers")
public class Answers {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "correct_answer")
    private String answer;

}
