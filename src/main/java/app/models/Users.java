package app.models;


import jakarta.persistence.CollectionTable;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jdk.jfr.Relational;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Users")
public class Users {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "user_name", nullable = false, unique = true)
    @Id
    @jakarta.persistence.Id
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "current_level", nullable = false)
    private long currentLevel=1;


}
