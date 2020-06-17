package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.entity.QuestionsBank;
import com.revature.service.QuestionsBankService;

public class QuestionsBankController {
	
	@Autowired
	QuestionsBankService qbs;
		
	    @RequestMapping(value = "/addquestion", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public String insertQuestion (@RequestBody QuestionsBank qb) {
			return this.qbs.InsertQuestion(qb);
			
		}
}
