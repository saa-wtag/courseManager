package QuizApp.model.question;
import QuizApp.model.option.Option;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_question")
@Getter
@Setter
public class Question implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int quesId;

    @Column(nullable = false)
    private String quesDetails;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options;

    public Question() {
        this.options = new ArrayList<>();
    }
}
