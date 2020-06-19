package com.revature;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controller.QuizController;
import com.revature.entity.Quiz;

@SpringBootTest
@RunWith(SpringRunner.class)
class EvaluationQuizTests {
	
	@Autowired
	QuizController qc;

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

}
