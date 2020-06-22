package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.Quiz;
import com.revature.repo.QuizRepository;
import com.revature.repo.SubjectRepository;


@Service
public class QuizService {
	
	QuizRepository qr;
	SubjectRepository sr;
	
	@Autowired
	public QuizService(QuizRepository qRepository, SubjectRepository sRepository) {
		this.qr = qRepository;
		this.sr = sRepository;
	}

	public List<Quiz> quizList() {
		return qr.findAll();
	}
	
	public List<Quiz> findQuizBySubject(long sId) {
		return qr.findQuizBySubject(sr.findById(sId).get());
	}
	
	public Optional<Quiz> findById(Long id) {
		Optional<Quiz> q = qr.findById(id);
		q.get().setSubjectId(q.get().getSubject().getSubjectId());
		return q;
	}

	public Quiz insertQuiz(Quiz q) { 
		q.setSubject(sr.findById(q.getSubjectId()).get()); 
		//return qr.save(q);
		qr.save(q);
		return q;
	}

	public String deleteQuizById(Long id) {
		qr.deleteById(id);
		return "{'message':'Quiz deleted successfully'}";
	}
	
	public List<Quiz> getAllQuizzes(){
		return this.qr.findAll();
	}
	
}

