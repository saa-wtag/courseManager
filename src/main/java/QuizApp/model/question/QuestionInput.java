package QuizApp.model.question;

import QuizApp.model.option.Option;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class QuestionInput {

    @NotBlank(message = "Question details must be provided")
    @Size(min = 8, message = "This is too short for a question!")
    private String quesDetails;

    private List<Option> options;
}
