package com.example.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Answer;
import com.example.app.model.Question;
@RestController
public class QuizController {
	
	@Autowired
	private QuestionAnswerService serviceImp;
	
	@Autowired
	private QuestionRepository questionRepo;


	@GetMapping("/questions")
	public List<Question> getQuestions() {
		return serviceImp.getQuestions();
		
	}
	
	//Get a question by Id
		@GetMapping("/question/{id}")
		public Optional<Question> addQuestion(@PathVariable(value="id") Long id  ) {
			Optional<Question> temp = serviceImp.findQuestions(id);
			return temp;
		}
		
		//Adding question
		@PostMapping("/addquestion")
		public Optional<Question> addAnswer(@RequestBody Question question) {
			
			return Optional.of(serviceImp.addQuestion(question));

		}
	
	@PutMapping("/Updatequestion/id/{id}")
	public Question UpdateQuestionAndAddAnswer(@RequestBody Question question, @PathVariable(value = "id") Long id) {
		if(questionRepo.findById(id).isPresent()){
			serviceImp.changeQuestion(question, id);
		}
		return question;
		
		
	}
	
	//Add answers to a question by Question Id
		@PostMapping("/addanswer/{id}")
		public Question addAnswer(@RequestBody Answer answer, @PathVariable(value="id") Long id) {
			
			return serviceImp.addQuestionsAnswers(id, answer);

		}
	

}
