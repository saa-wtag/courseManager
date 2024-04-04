package QuizApp.model.question;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;


@Getter
@Setter
public class QuestionUpdate {

    @NotBlank(message = "Question details can not be empty!")
    private String quesDetails;
}
