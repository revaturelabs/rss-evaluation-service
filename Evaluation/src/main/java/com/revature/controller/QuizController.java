package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Quiz;
import com.revature.service.QuizService;

@RestController
@RequestMapping(value="/quiz")
public class QuizController {
	
	@Autowired
	QuizService qs;
	
	@RequestMapping(value = "/addquiz", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Quiz insertQuiz (@RequestBody Quiz q) {
		System.out.println(q);
		return this.qs.insertQuiz(q);
	}
	
	@RequestMapping(value = "/findbyid", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Quiz findQuizById (@RequestBody Quiz q) {
		System.out.println(q);
		Quiz q1 = qs.findById(q.getQuizId()).get();
		q1.setSubjectId(q1.getSubject().getSubjectId());
		return q1;
	}
	
	@RequestMapping(value = "/findbysubject", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public List<Quiz> findQuizBySubjectId (@RequestBody Quiz q) {
		System.out.println(q);
		//return this.qs.findQuizBySubject(q.getSubjectId());
		List<Quiz> q1 = qs.findQuizBySubject(q.getSubjectId());
		for (int i = 0; i < q1.size(); i++) {
		    q1.get(i).setSubjectId(q.getSubjectId());
		}
		return q1;
	}
}
