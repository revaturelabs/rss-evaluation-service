package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.AnswersBank;
import com.revature.service.AnswersBankService;
import com.revature.service.UserQuizScoreService;

@RestController
@RequestMapping(value="/answer")
public class AnswersBankController {
	
	AnswersBankService abs;
	UserQuizScoreService uqs;
	
	@Autowired
	public AnswersBankController(AnswersBankService abService, UserQuizScoreService uqService) {
		this.abs = abService;
		this.uqs = uqService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AnswersBank> findAll(){
		return abs.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AnswersBank> findAnswersByAttempt(@PathVariable("id") long id){
		return abs.findAnswersByAttempt(uqs.findById(id));
	}
}
