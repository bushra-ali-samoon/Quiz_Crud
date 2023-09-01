package com.project.quizApp.Repository;

import com.project.quizApp.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
public interface QuizRepo extends JpaRepository<Quiz,Integer> {
}
