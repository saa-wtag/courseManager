package QuizApp.model.option;

import QuizApp.model.question.Question;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OptionInput {

    @NotNull(message = "Option details must be provided")
    private String optionDetails;

    @NotNull(message = "Option's correctness must be provided")
    private boolean ifCorrect;

    @NotNull(message = "Option's question id must be provided")
    private int questionId;

    private Question question;
}
