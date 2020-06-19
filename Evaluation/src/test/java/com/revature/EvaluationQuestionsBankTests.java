package com.revature;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controller.QuestionsBankController;
import com.revature.entity.QuestionsBank;
import com.revature.entity.Quiz;

@SpringBootTest
@RunWith(SpringRunner.class)
class EvaluationQuestionsBankTests {
	
	@Autowired
	QuestionsBankController qc;
	
	@Test
	public void insertQuestion() throws Exception{
		QuestionsBank q = new QuestionsBank();
		Quiz quiz = new Quiz();
		Long qid = (long) 450;
		quiz.setQuizId(qid);
		q.setQuiz(quiz);
		q.setQuestion("What is Java?");
		q.setCorrectAnswer("Object Oriented Programming Language");
		q.setOption1("Object Oriented Programming Language");
		q.setOption2("a kind of coffee");
		q.setOption3("A name of a island");
		q.setOption4(" An interpreted language");
		q.setOption5("None of them");
		q.setQuestionValue(5);
		QuestionsBank result = qc.insertQuestion(q);
		int value = result.getQuestionValue();
		assertEquals(5, value);
	}

}
