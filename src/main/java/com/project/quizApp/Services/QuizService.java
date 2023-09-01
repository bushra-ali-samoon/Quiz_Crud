package com.project.quizApp.Services;

import com.project.quizApp.Entity.Question;
import com.project.quizApp.Entity.QuestionWrapper;
import com.project.quizApp.Entity.Quiz;
import com.project.quizApp.Entity.Response;
import com.project.quizApp.Repository.QuestionsRepo;
import com.project.quizApp.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;


    @Autowired
    QuestionsRepo questionsRepo;
    private List<Question> questions;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionsRepo.findQuestionsCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);


        return new ResponseEntity<>("succesfully", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> QuestionsFormDB = quiz.get().getQuestions();
        List<QuestionWrapper> QuestionsForUser = new ArrayList<>();
        for (Question q : QuestionsFormDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(),
                    q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            QuestionsForUser.add(qw);
        }
        return new ResponseEntity<>(QuestionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculatedResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for (Response response : responses) {
            if (response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }


        return new ResponseEntity<>(right,HttpStatus.OK);
    }

}
