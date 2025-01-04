package app.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Answers {
    private String answer;
    @Id
    private Long currentLevel;
}
