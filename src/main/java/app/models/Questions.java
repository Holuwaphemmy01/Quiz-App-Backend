package app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "questions")
public class Questions {
    @Id
    private long id;
    @Column(name = "questions")
    private String question;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "options")
    private List<String>  options;

}
