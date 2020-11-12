package com.revature.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.beans.Question;
import com.revature.beans.Result;
import com.revature.entity.AnswersBank;
import com.revature.entity.QuestionsBank;
import com.revature.entity.UserQuizScore;
import com.revature.service.AnswersBankService;
import com.revature.service.QuestionsBankService;
import com.revature.service.UserQuizScoreService;

import com.revature.util.LogThis;


@RestController
@RequestMapping(value="/question")
public class QuestionsBankController {
	
	QuestionsBankService qbs;
	UserQuizScoreService uqss;
	AnswersBankService abs;
	
	//We use constructor auto-wiring to auto-wired multiple services.
	@Autowired
	public QuestionsBankController(QuestionsBankService qbService, UserQuizScoreService uqsService, AnswersBankService abService) {
		this.qbs=qbService;
		this.uqss=uqsService;
		this.abs=abService;
	}
	
	@GetMapping
	public List<QuestionsBank> getAllQuestions(){
		return qbs.findAllQuestions();
	}

	//Change endpoint from /add to /admin/add
	 @RequestMapping(value = "/admin/add", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	    @ResponseBody()
	    public QuestionsBank insertQuestion (@RequestBody QuestionsBank qb) {
	    	//Log4j
	    	LogThis.LogIt("info","Question added");
			return this.qbs.InsertQuestion(qb);
	 	}
	 
	 //Change endpoint from /delete to /admin/delete
	 @RequestMapping(value = "/admin/delete", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	    @ResponseBody()
	    public List<String> deleteQuestion (@RequestBody QuestionsBank qb) {
	    	//Log4j
	    	LogThis.LogIt("info","Question deleted");
			return this.qbs.deleteQuestion(qb.getQuestionId());
	 	}
	 
	 	//Change endpoint from /addall to /admin/addall
		@RequestMapping(value = "/admin/addall", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public List<QuestionsBank> insertAllQuestions (@RequestBody List<QuestionsBank> qbList) {
	    	List<QuestionsBank> qbList1 = new ArrayList<QuestionsBank>();
	    	for (int i = 0; i < qbList.size(); i++) {
	    		qbList1.add(qbs.InsertQuestion(qbList.get(i)));
	    	}
	    	//Log4j
	    	LogThis.LogIt("info","Multiple Question added");
	    	return qbList1;
			
		}
		
		//change endpoint from /submitQuiz to /forward
		@RequestMapping(value = "/forward", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public Result calculatePoints (@RequestBody List<Question> qList) {
			System.out.print(qList);
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
	    		qb=(qbs.getQuestion(qList.get(i).getQuestionId()));
	    		System.out.println(qb);
	    		userEmail = qList.get(i).getUserEmail();
	    		quizId = qb.getQuiz().getQuizId();
	    		
	    		if(qList.get(i).getSelectedAnswer().equalsIgnoreCase(qb.getCorrectAnswer())){
	    			totalPoints += qb.getQuestionValue();
	    			System.out.println(qList.get(i).getQuestionValue());
	    			correctAnswers++;
	    		}
	    	}
	    	
	    	uqs.setSubmitDate(date);
	    	uqs.setUserEmail(userEmail);
	    	uqs.setQuizId(quizId);
	    	uqs.setUserScore(totalPoints);
	    	
	    	UserQuizScore attempt = uqss.InsertUserQuizScore(uqs);
	    	
	    	//Sets Answers into DB, tied to attempt UserQuizScore for future ref.
	    	AnswersBank temp;
	    	for(Question q : qList) {
	    		temp = new AnswersBank();
	    		temp.setQuestion(qbs.getQuestion(q.getQuestionId()));
	    		temp.setUserAnswer(q.getSelectedAnswer());
	    		temp.setUserScore(attempt);
	    		System.out.println(temp);
	    		abs.addAnswersBank(temp);
	    	}
	    	
	    	result.setTotalQuestions(totalQuestions);
	    	result.setCorrectAnswers(correctAnswers);
	    	result.setTotalPoints(totalPoints);
	    	
	    	return result;
		}
	    
		//change endpoint from /getquestions to /questions
		//EDIT: changed requestbody questionbank qb to path variable
		@RequestMapping(value = "/questions/{id}", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public List<QuestionsBank> getQuestionsByQuizId (@PathVariable long id) {
			
			
	    	List<QuestionsBank> qbList;
			List<Question> qList= new ArrayList<Question>();
			Question q = null;
			
	    	qbList = this.qbs.findQuestionsByQuiz(id);
	    	
	    	for (int i = 0; i < qbList.size(); i++) {
	    		q = new Question();
			    q.setQuestionId(qbList.get(i).getQuestionId());
			    q.setQuestionValue(qbList.get(i).getQuestionValue());
			    q.setQuestion(qbList.get(i).getQuestion());

			    q.setOptions(qbList.get(i).getOptions());
//			    q.setOption1(qbList.get(i).getOption1());
//			    q.setOption2(qbList.get(i).getOption2());
//			    q.setOption3(qbList.get(i).getOption3());
//			    q.setOption4(qbList.get(i).getOption4());
//			    q.setOption5(qbList.get(i).getOption5());
			    qList.add(q);
			}
//			return qList;
	    	return this.qbs.findQuestionsByQuiz(id);
			
		}
		
		//change endpoint from /getquestionsadmin to /admin/questions
		//EDIT: changed requestbody questionbank qb to path variable
		@RequestMapping(value = "/admin/questions/{id}", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public List<QuestionsBank> getQuestionsByQuizIdAdmin (@PathVariable long id) {
	    
			return this.qbs.findQuestionsByQuiz(id);
			
		}
}
