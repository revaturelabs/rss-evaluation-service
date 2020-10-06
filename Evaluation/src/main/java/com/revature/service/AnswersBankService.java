package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.AnswersBank;
import com.revature.entity.QuestionsBank;
import com.revature.entity.Quiz;
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
	
	//Method to find all questions.
	//list of answer banks (every question id will have an answer id)
		public List<AnswersBank> findUsersAnswersByQuiz(AnswersBank ab){
			
			List<AnswersBank> answers = abr.findAll();
			List<AnswersBank> userAnswers = new ArrayList<>();
			for(AnswersBank aB : answers) {
				if(aB.getQuiz().equals(ab.getQuiz())) {
					
					userAnswers.add(aB);
				}
			}
			
			return userAnswers;
		}
		
		//Methods to find questions by quiz.
		//we get only quizId from front-end and then we find object of quiz using that quizId. So that we use it to find the questions by quiz.
		public List<String> findCorrectAnswersByQuiz(AnswersBank ab){
			
			List<QuestionsBank> questions = qbr.findQuestionsByQuiz(ab.getQuiz());
	
			List<String> correctAnswers = new ArrayList<>();
			
			for(QuestionsBank qb : questions) {
				
				correctAnswers.add(qb.getCorrectAnswer());
			}
			
			return correctAnswers;		
		}
		
}
