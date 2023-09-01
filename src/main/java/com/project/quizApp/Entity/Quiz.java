package com.project.quizApp.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "Quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private  Integer id;
    private  String title;
    @ManyToMany
    private List<Question> questions;

//    @ManyToMany
//    private List<Question> question;

}
