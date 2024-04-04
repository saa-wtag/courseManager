package QuizApp.model.user;
import QuizApp.model.quiz.Quiz;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Quiz> quizzes;
    public enum UserRole {
        USER, ADMIN
    }

}
