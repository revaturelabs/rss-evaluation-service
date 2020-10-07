package com.revature.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.Quiz;
import com.revature.repo.QuizRepository;
import com.revature.repo.SubjectRepository;


@Service
public class QuizService {
	
	QuizRepository qr;
	SubjectRepository sr;
	
	//We use constructor auto-wiring to auto-wired multiple repositories.
	@Autowired
	public QuizService(QuizRepository qRepository, SubjectRepository sRepository) {
		this.qr = qRepository;
		this.sr = sRepository;
	}
	
	
	//Method to find quiz by Subject
	public List<Quiz> findQuizBySubject(long sId) {
		return qr.findQuizBySubject(sr.findById(sId).get());
	}
	
	//Method to find quiz by quiz ID.
	public Quiz findById(Long quizid) {
		Quiz q = qr.findById(quizid).get();
		q.setSubjectId(q.getSubject().getSubjectId());
		return q;
	}
	
	//Methods to insert quiz.
	//we get only subectId from front-end and then we find subject using that subjectId. 
	//Then we set that subject in the quiz object to insert that record into database.
	public Quiz insertQuiz(Quiz q) { 
		q.setSubject(sr.findById(q.getSubjectId()).get()); 
		return qr.save(q);
	}
	
	//Method to delete quiz by quiz ID.
	public String deleteQuizById(Long id) {
		qr.deleteById(id);
		return "{'message':'Quiz deleted successfully'}";
	}
	
	//Method to find all quiz.
	public List<Quiz> getAllQuizzes(){
		return this.qr.findAll();
	}
	
	//GROUP 2 creating update method
	public Quiz updateQuizAttempt(Quiz quiz) {
		return qr.save(quiz);
	}
	
}

