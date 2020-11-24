package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.AnswersBank;
import com.revature.entity.QuestionsBank;
import com.revature.entity.Quiz;
import com.revature.entity.UserQuizScore;
import com.revature.repo.AnswersBankRepository;
import com.revature.repo.QuestionsBankRepository;
import com.revature.repo.QuizRepository;
import com.revature.repo.SubjectRepository;
import com.revature.repo.UserQuizScoreRepository;

@Service
public class AnswersBankService {

	QuestionsBankRepository qbr;
	QuizRepository qr;
	SubjectRepository sr;
	AnswersBankRepository abr;
	UserQuizScoreRepository uqsr;
	QuizService qs;
	
	//We use constructor auto-wiring to auto-wired multiple repositories.
	@Autowired
	public AnswersBankService(QuestionsBankRepository qbRepository, QuizRepository qRepository, SubjectRepository sRepository, AnswersBankRepository aRepository, UserQuizScoreRepository uRepository, QuizService qService) {
		this.qbr = qbRepository;
		this.qr = qRepository;
		this.sr = sRepository;
		this.abr = aRepository;
		this.uqsr = uRepository;
		this.qs = qService;
	}
	
	
		//Returns List of answers based on a specific UserQuizScore
		public List<AnswersBank> findAnswersByAttempt(UserQuizScore attempt){
			
			List<AnswersBank> answers = abr.findAnswersByUserScore(attempt);
			return answers;
		}
		
		
		//Returns a List of only correct answers based on a specific Quiz
//		public List<String> findCorrectAnswersByQuiz(Quiz q){
//			
//			List<QuestionsBank> questions = qbr.findQuestionsByQuiz(q);
//	
//			List<String> correctAnswers = new ArrayList<>();
//			
//			for(QuestionsBank qb : questions) {
//				
//				correctAnswers.add(qb);
//			}
//			
//			return correctAnswers;		
//		}
		
		
		//Method to add an AnswersBank
		public AnswersBank addAnswersBank(AnswersBank ab) {
			ab.setQuestion(qbr.findById(ab.getQuestion().getQuestionId()).get());
			ab.setUserScore(uqsr.findById(ab.getUserScore().getUserScoreId()).get());
			return abr.save(ab);
		}
		
		//Method list of AnswersBank, for debugging
		public List<AnswersBank> findAll(){
			return abr.findAll();
		}
}
