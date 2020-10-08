package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.AnswersBank;
import com.revature.service.AnswersBankService;

@RestController
@RequestMapping(value="/answer")
public class AnswersBankController {
	
	AnswersBankService abs;
	
	@Autowired
	public AnswersBankController(AnswersBankService abService) {
		this.abs = abService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AnswersBank> findAll(){
		return abs.findAll();
	}
	//METHOD TO PASS BACK ANSWERS BASED ON USERSCOREQUIZ ID
	
	
}
