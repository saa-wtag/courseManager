package QuizApp.model.option;

import QuizApp.model.question.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionUpdate {

    private String optionDetails;
    private boolean ifCorrect;
    private int questionId;
    private Question question;
}
