package com.revature;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.revature.controller.QuestionsBankController;
import com.revature.controller.QuizController;
import com.revature.controller.SubjectController;
import com.revature.entity.Option;
import com.revature.entity.QuestionsBank;
import com.revature.entity.Quiz;
import com.revature.entity.Subject;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EvaluationAppTestsJUnit {
	
	@Autowired
	QuestionsBankController qbc;
	@Autowired
	QuizController qc;
	@Autowired
	SubjectController sc;
	
	
	// Questions Bank Service JUnit Tests
	
	@Test
	public void insertQuestion() throws Exception{
		QuestionsBank q = new QuestionsBank();
		long id = 1;
		q.setQuizId(id);
		q.setQuestion("What is Java?");
		List<Option> options = new ArrayList<Option>();
		Option opt1 = new Option();
		Option opt2 = new Option();
		options.add(opt1);
		options.add(opt2);
		q.setQuestionValue(5);
		QuestionsBank result = qbc.insertQuestion(q);
		int value = result.getQuestionValue();
		assertEquals(5, value);
	}
	
	// Quiz Service JUnit Tests
	
//	@Test
//	void insertQuiz() throws Exception{
//		Quiz q = new Quiz();
//		q.setQuizTopic("Eureka");
//		q.setCreatorEmail("vee@gmail.com");
//		q.setQuizDescription("This is a optional question.");
//		long id = 2;
//		q.setSubjectId(id);
//		Quiz result = qc.insertQuiz(q);
//		String topic = result.getQuizTopic();
//		assertEquals("Eureka", topic);
//	}
	
	@Test
	void findQuizById() throws Exception{
		Quiz q = new Quiz();
		long id = 1;
		q.setQuizId(id);
		assertThat(qc.findQuizById(q)).isNotNull();
	}
	
	// Subjects Service JUnit Tests
	
//	@Test
//	void insertSubject() throws Exception{
//		Subject s = new Subject();
//		s.setSubjectName("Hibernate");
//		String result = sc.insertSubject(s);
//		assertEquals("{'message':'Subject added successfully.'}", result);
//	}
	
	@Test
	void getAllSubjects() throws Exception{
		List<Subject> sublist;
		sublist = sc.getAllSubjects();
		assertTrue(sublist.size() != 0);
	}
	

}
