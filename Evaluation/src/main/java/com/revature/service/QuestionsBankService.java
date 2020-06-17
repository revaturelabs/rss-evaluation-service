package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.entity.QuestionsBank;
import com.revature.entity.Quiz;
import com.revature.repo.QuestionsBankRepository;

public class QuestionsBankService {
	
	@Autowired
	QuestionsBankRepository qbr;
	
	public List<QuestionsBank> findAllQuestions(){
		return qbr.findAll();
	}
	
	public List<QuestionsBank> findQuestionsByQuizId(Quiz quiz){
		return qbr.findQuestionsByQuiz(quiz);
		
	}

}
