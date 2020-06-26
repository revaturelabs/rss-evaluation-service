package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.QuestionsBank;
import com.revature.repo.QuestionsBankRepository;
import com.revature.repo.QuizRepository;
import com.revature.repo.SubjectRepository;

@Service
public class QuestionsBankService {
	
	QuestionsBankRepository qbr;
	QuizRepository qr;
	SubjectRepository sr;
	
	//We use constructor auto-wiring to auto-wired multiple repositories.
	@Autowired
	public QuestionsBankService(QuestionsBankRepository qbRepository, QuizRepository qRepository, SubjectRepository sRepository) {
		this.qbr=qbRepository;
		this.qr = qRepository;
		this.sr = sRepository;
	}
	
	//Method to find all questions.
	public List<QuestionsBank> findAllQuestions(){
		return qbr.findAll();
	}
	
	//Methods to find questions by quiz.
	//we get only quizId from front-end and then we find object of quiz using that quizId. So that we use it to find the questions by quiz.
	public List<QuestionsBank> findQuestionsByQuiz(QuestionsBank qb){
		qb.setQuiz(qr.findById(qb.getQuizId()).get());
		return qbr.findQuestionsByQuiz(qb.getQuiz());	
	}
	
	//Method to get question by question ID.
	public QuestionsBank getQuestion(long questionId){
		return this.qbr.findById(questionId).get();
	}
	
	//Methods to insert question.
	//we get only quizId from front-end and then we find quiz using that quizId. 
	//Then we set that quiz in the questionsbank object to insert that record into database.
	public QuestionsBank InsertQuestion(QuestionsBank qb) {
		qb.setQuiz(qr.findById(qb.getQuizId()).get()); 
		return qbr.save(qb);
	}
	
	//Method to delete question by question ID.
	public List<String> deleteQuestion(long questionId) {
		List<String> tmp = new ArrayList<String>();
		this.qbr.deleteById(questionId);
		tmp.add("deleted question with id " + questionId);
		return tmp;
	}
	

}
