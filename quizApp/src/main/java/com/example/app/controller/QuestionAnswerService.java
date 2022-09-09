package com.example.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Answer;
import com.example.app.model.Question;
@Service
public class QuestionAnswerService implements QuizService {
	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private AnswerRepository answerRepo;
	
	//Question 
	//Getting a question by an ID
	@Override
	public Optional<Question> findQuestions(Long id) {
		return questionRepo.findById(id);
	}
	
	//Getting questions
	@Override
	public List<Question> getQuestions() {
		return (List<Question>) questionRepo.findAll();
	}
	
	//Add question
	@Override
	public Question addQuestion(Question question) {
		
		return questionRepo.save(question);
	}

	//Adding answers
	@Override
	 public Question addQuestionsAnswers(Long id, Answer answer){
		Question tempQuestion = new Question();
		for (Question dummy : questionRepo.findAll()) {
			if(dummy.getId().equals(id)) {
				tempQuestion = dummy;
				System.out.println("Question exists");
				break;
			}
		}			
			List<Answer> tempAnswers = tempQuestion.getAnswer();
			tempAnswers.add(answer);
			System.out.println("Asnswer: " + tempAnswers.toString());
			tempQuestion.setAnswer(tempAnswers);
			System.out.println("QUESTION" + tempQuestion.toString());
			answerRepo.save(answer);
			questionRepo.save(tempQuestion);
			return tempQuestion;
			
		}
	

	@Override
	public Optional<Question> changeQuestion(Question question, Long Id){
		if(questionRepo.findById(Id).isPresent()) {
			Question questionExists = questionRepo.findById(Id).get();
			questionExists.setDetails(question.getDetails());
			questionExists.setShortInfo(question.getShortInfo());
			questionRepo.save(questionExists);
		}
		
		return questionRepo.findById(Id);
		
	}


}
