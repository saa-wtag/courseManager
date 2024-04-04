package QuizApp.controllers;

import QuizApp.QuizObjectMapper;
import QuizApp.model.question.Question;
import QuizApp.model.question.QuestionInput;
import QuizApp.model.question.QuestionUpdate;
import QuizApp.services.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // Endpoint for creating a new question
    @PostMapping("/")
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody QuestionInput questionInput) {
        Question question = QuizObjectMapper.convertQuestionInputToModel(questionInput);
        Question createdQuestion = questionService.createQuestion(question);
        return ResponseEntity.ok().body(createdQuestion);
    }

    // Endpoint for updating question details
    @PutMapping("/{questionId}")
    public ResponseEntity<Question> updateQuestionDetails(@PathVariable int questionId, @Valid @RequestBody QuestionUpdate questionUpdate) {
        Question question = QuizObjectMapper.convertQuestionUpdateToModel(questionUpdate);
        Question updatedQuestion = questionService.updateQuestionDetails(questionId, question);
        return ResponseEntity.ok().body(updatedQuestion);
    }

    // Endpoint for getting question details
    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestion(@PathVariable int questionId) {
        Question question = questionService.getQuestion(questionId);
        return ResponseEntity.ok(question);
    }

    // Endpoint for deleting a question
    @DeleteMapping("/{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable int questionId) {
        try {
            questionService.deleteQuestion(questionId);
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }
}
