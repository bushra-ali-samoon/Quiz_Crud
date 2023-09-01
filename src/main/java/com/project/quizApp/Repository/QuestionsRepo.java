package com.project.quizApp.Repository;

import com.project.quizApp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionsRepo extends JpaRepository<Question,Integer> {

      List<Question> findBycategory(String category);

     @Query(value = "SELECT * FROM  question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery =true)
      List<Question> findQuestionsCategory(@Param("category") String category,@Param("numQ") int numQ) ;



 }
