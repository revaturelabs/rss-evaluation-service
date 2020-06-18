package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
=======
>>>>>>> 9b0af920da8639d1903379a24403d89f14b6c8d2
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ResponseStatus;
=======
>>>>>>> 9b0af920da8639d1903379a24403d89f14b6c8d2
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.QuestionsBank;
import com.revature.service.QuestionsBankService;

<<<<<<< HEAD

@RestController
@RequestMapping("/question")
=======
@RestController
@RequestMapping(value="/question")
>>>>>>> 9b0af920da8639d1903379a24403d89f14b6c8d2
public class QuestionsBankController {
	
	@Autowired
	QuestionsBankService qbs;
<<<<<<< HEAD
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/addquestion", method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public String insertQuestion (@RequestBody QuestionsBank qb) {
		return this.qbs.InsertQuestion(qb);
	}

	

=======
		
	    @RequestMapping(value = "/add", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody()
	    public QuestionsBank insertQuestion (@RequestBody QuestionsBank qb) {
			return this.qbs.InsertQuestion(qb);
			
		}
	    
	    
>>>>>>> 9b0af920da8639d1903379a24403d89f14b6c8d2
}
