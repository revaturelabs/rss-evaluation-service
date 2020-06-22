package com.revature.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Question;
import com.revature.entity.QuestionsBank;
import com.revature.entity.Result;
import com.revature.entity.UserQuizScore;
import com.revature.service.QuestionsBankService;
import com.revature.service.UserQuizScoreService;

@RestController
@RequestMapping(value="/question")
public class QuestionsBankController {
	
	@Autowired
	QuestionsBankService qbs;
	
	@Autowired
	UserQuizScoreService uqss;
		
	    @RequestMapping(value = "/add", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public QuestionsBank insertQuestion (@RequestBody QuestionsBank qb) {
			return this.qbs.InsertQuestion(qb);
			
		}

		@RequestMapping(value = "/addall", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public List<QuestionsBank> insertAllQuestions (@RequestBody List<QuestionsBank> qbList) {
	    	List<QuestionsBank> qbList1 = new ArrayList<QuestionsBank>();
	    	for (int i = 0; i < qbList.size(); i++) {
	    		qbList1.add(qbs.InsertQuestion(qbList.get(i)));
	    	}
	    	return qbList1;
			
		}
		
		@RequestMapping(value = "/submitquiz", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public Result calculatePoints (@RequestBody List<Question> qList) {
	    	QuestionsBank qb = null;
	    	UserQuizScore uqs = new UserQuizScore();
	    	Result result = new Result();
	    	String userEmail = null;
	    	long quizId = 0;
	    	int correctAnswers = 0;
	    	int totalPoints = 0;
	    	int totalQuestions =qList.size();
	    	Date date = new Date();
	    	
	    	for (int i = 0; i < qList.size(); i++) {
	    		
	    		qb = new QuestionsBank();
	    		qb=(qbs.getQuestion(qList.get(i).getQuestionId()).get());
	    		userEmail = qList.get(i).getUserEmail();
	    		quizId = qb.getQuiz().getQuizId();
	    		
	    		if(qList.get(i).getSelectedAnswer().equalsIgnoreCase(qb.getCorrectAnswer())){
	    			totalPoints += qList.get(i).getQuestionValue();
	    			correctAnswers++;
	    		}
	    	}
	    	
	    	uqs.setSubmitDate(date);
	    	uqs.setUserEmail(userEmail);
	    	uqs.setQuizId(quizId);
	    	uqs.setUserScore(totalPoints);
	    	
	    	uqss.InsertUserQuizScore(uqs);
	    	
	    	result.setTotalQuestions(totalQuestions);
	    	result.setCorrectAnswers(correctAnswers);
	    	result.setTotalPoints(totalPoints);
	    	
	    	return result;
		}
	    
		@RequestMapping(value = "/getquestions", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public List<Question> getQuestionsByQuizId (@RequestBody QuestionsBank qb) {
			
	    	List<QuestionsBank> qbList;
			List<Question> qList= new ArrayList<Question>();
			Question q = null;
			
	    	qbList = this.qbs.findQuestionsByQuiz(qb);
	    	
	    	for (int i = 0; i < qbList.size(); i++) {
	    		q = new Question();
			    q.setQuestionId(qbList.get(i).getQuestionId());
			    q.setQuestionValue(qbList.get(i).getQuestionValue());
			    q.setQuestion(qbList.get(i).getQuestion());
			    q.setOption1(qbList.get(i).getOption1());
			    q.setOption2(qbList.get(i).getOption2());
			    q.setOption3(qbList.get(i).getOption3());
			    q.setOption4(qbList.get(i).getOption4());
			    q.setOption5(qbList.get(i).getOption5());
			    qList.add(q);
			}
			return qList;
			
		}
}
