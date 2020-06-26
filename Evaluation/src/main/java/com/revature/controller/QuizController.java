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
import com.revature.util.LogThis;

@RestController
@RequestMapping(value="/quiz")
public class QuizController {
	
	@Autowired
	QuizService qs;
	
	//Change endpoint from /addquiz to /admin/add
	@RequestMapping(value = "admin/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Quiz insertQuiz (@RequestBody Quiz q) {
		//Log4j
		LogThis.LogIt("info","Quiz added"+" "+q.getQuizTopic());
		System.out.println(q);
		return this.qs.insertQuiz(q);
	}
	
	//Change endpoint from /findbyid to /obtain/id
	@RequestMapping(value = "/obtain/id", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Quiz findQuizById (@RequestBody Quiz q) {
		System.out.println(q);
		Quiz q1 = qs.findById(q.getQuizId());
		q1.setSubjectId(q1.getSubject().getSubjectId());
		return q1;
	}
	
	//Change endpoint from /findbysubject to /obtain/subject
	@RequestMapping(value = "/obtain/subject", method = RequestMethod.POST,
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
	
	//Change endpoint from /getallquizzes to /obtain/all
	@RequestMapping(value = "/obtain/all", method = RequestMethod.GET)
	@ResponseBody()
	public List<Quiz> getAllQuizzes(){
		return this.qs.getAllQuizzes();
	}
}
