package com.project.quizApp.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String questionTitle;
    private  String option1;
    private  String option2;
    private  String option3;
    private  String option4;
    private  String  rightAnswer;
    private  String difficultLevel;
    private String category;


//    public Question(String difficultLevel) {
//        this.difficultLevel = difficultLevel;
//    }
}
