package app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "options")
public class Options {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "option")
    private String option;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Questions question;


    @Override
    public String toString() {
        return "Options{ option='" + option + "'}";
    }
}
