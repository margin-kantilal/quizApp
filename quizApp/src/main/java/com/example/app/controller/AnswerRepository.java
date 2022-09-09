package com.example.app.controller;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.model.Answer;
import com.example.app.model.Question;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

	Optional<Answer> findById(Long id);
	
}
