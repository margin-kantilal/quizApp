package com.example.app.controller;

import java.util.List;
import java.util.Optional;

import com.example.app.model.Answer;
import com.example.app.model.Question;

public interface QuizService {
	
	 Optional<Question> findQuestions(Long id);		
	 List<Question> getQuestions();
	 Question addQuestionsAnswers(Long id, Answer answer);
	Optional<Question> changeQuestion(Question question, Long Id);
	Question addQuestion(Question question);
	
	
}
