package com.example.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.model.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	 Question findById(long id);
	List<Question> findAll();
	

}
