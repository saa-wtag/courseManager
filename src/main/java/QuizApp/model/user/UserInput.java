package QuizApp.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class UserInput {
    @NotBlank(message = "User name must be provided")
    @Size(min = 3, message = "Given Name is too short")
    private String userName;

    @NotBlank(message = "User email must be provided")
    @Email
    private String userEmail;

    @NotBlank(message = "User password must be provided")
    @Size(min = 3, message = "Given password is too short")
    private String userPassword;
}
