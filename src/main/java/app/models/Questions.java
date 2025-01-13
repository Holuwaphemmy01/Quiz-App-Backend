package app.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "questions")
public class Questions {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "question")
    private String question;

    @JsonManagedReference
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Options>  options;


    @Override
    public String toString() {
        return "Questions{id=" + id + ", question='" + question + "'}";
    }
}
