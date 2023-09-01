package com.project.quizApp.Controller;

import com.project.quizApp.Entity.Question;
import com.project.quizApp.Services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionsController {

    @Autowired
    QuestionsService questionService;

    @GetMapping("allquestions")
   public ResponseEntity<List<Question>> getAllQuestions(){
        return  questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public  ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);

    }

     @PostMapping("add")
     public  ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
     }


}
