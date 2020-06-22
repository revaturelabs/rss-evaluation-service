package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.UserQuizScore;
import com.revature.repo.QuizRepository;
import com.revature.repo.UserQuizScoreRepository;

@Service
public class UserQuizScoreService {

	UserQuizScoreRepository uqsr;
	QuizRepository qr;
	
	@Autowired
	public UserQuizScoreService(UserQuizScoreRepository uqsRepository, QuizRepository qRepository) {
		this.uqsr=uqsRepository;
		this.qr = qRepository;
	}
	
	public UserQuizScore InsertUserQuizScore(UserQuizScore uqs) {
		uqs.setQuiz(qr.findById(uqs.getQuizId()).get()); 
			return uqsr.save(uqs);
	}
}
