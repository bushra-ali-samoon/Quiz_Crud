package com.project.quizApp.Services;

import com.project.quizApp.Entity.Question;
import com.project.quizApp.Repository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {


    @Autowired
     private QuestionsRepo questionsRepo;
     public ResponseEntity <List<Question>> getAllQuestions() {
         try{
             return   new ResponseEntity<>(questionsRepo.findAll(), HttpStatus.OK);

         }catch (Exception e){
             e.printStackTrace();{

             }
             return    new ResponseEntity<>(questionsRepo.findAll(), HttpStatus.BAD_REQUEST);

         }

     }


    public  ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return   new ResponseEntity<>(questionsRepo.findAll(), HttpStatus.OK);

        }catch (Exception e) {
            e.printStackTrace();
            {

            }
            return new ResponseEntity<>(questionsRepo.findAll(), HttpStatus.BAD_REQUEST);

         }
    }

    public ResponseEntity<String> addQuestion(Question question) {
         questionsRepo.save(question);
         try{
             return new ResponseEntity<>("succesfully added",HttpStatus.CREATED) ;
         }catch(Exception e){
             e.printStackTrace();
         }

         return new ResponseEntity<>("succesfully added",HttpStatus.CREATED) ;
    }
}
