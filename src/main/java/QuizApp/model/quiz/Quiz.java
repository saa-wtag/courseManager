package QuizApp.model.quiz;

import QuizApp.model.question.Question;
import QuizApp.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tbl_quiz")
@Getter
@Setter
public class Quiz {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private long score;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Question> questions;

}
