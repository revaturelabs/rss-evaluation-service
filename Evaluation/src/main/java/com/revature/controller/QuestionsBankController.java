package com.revature.controller;

import java.util.ArrayList;
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
import com.revature.service.QuestionsBankService;

@RestController
@RequestMapping(value="/question")
public class QuestionsBankController {
	
	@Autowired
	QuestionsBankService qbs;
	
		
	    @RequestMapping(value = "/add", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public QuestionsBank insertQuestion (@RequestBody QuestionsBank qb) {
			return this.qbs.InsertQuestion(qb);
			
		}
	    
		@RequestMapping(value = "/getquestions", method = RequestMethod.GET,
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
