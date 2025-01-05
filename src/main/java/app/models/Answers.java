package app.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "answers")
public class Answers {
    @Column(name = "answer")
    private String answer;
    @Id
    @Column(name = "id")
    private long currentLevel;
}
