package com.project.quizApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
 //extends SpringBootServletInitializer
@SpringBootApplication
public class QuizAppApplication   {
	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(QuizAppApplication.class);
//	}
}
