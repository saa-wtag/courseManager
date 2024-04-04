package QuizApp.model.option;
import QuizApp.model.question.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tbl_option")
@Getter
@Setter
public class Option implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int optionId;

    @Column(nullable = false)
    private String optionDetails;

    @Column(nullable = false)
    private boolean ifCorrect;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("options")
    private Question question;

}
