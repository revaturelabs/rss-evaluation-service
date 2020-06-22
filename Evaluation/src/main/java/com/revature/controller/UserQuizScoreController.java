package com.revature.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.UserQuizScore;
import com.revature.service.UserQuizScoreService;

@RestController
@RequestMapping(value="/userscore")
public class UserQuizScoreController {
	
	@Autowired
	UserQuizScoreService uqss;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public UserQuizScore insertQuestion (@RequestBody UserQuizScore uqs) {
		Date d = new Date();
		uqs.setSubmitDate(d);
		return this.uqss.InsertUserQuizScore(uqs);
		
	}
}
