package com.revature;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.revature.controller.QuestionsBankController;
import com.revature.entity.QuestionsBank;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EvaluationQuestionsBankTests {
	
	@Autowired
	QuestionsBankController qc;
	
	@Test
	public void insertQuestion() throws Exception{
		QuestionsBank q = new QuestionsBank();
		long id = 1;
		q.setQuizId(id);
		q.setQuestion("What is Java?");
		q.setCorrectAnswer("Object Oriented Programming Language");
		//TODO: create a list of options and to it then set it with setter
		List<String> options = new ArrayList<String>();
		options.add("option1");
		options.add("options2");
		q.setOptions(options);
		
//		q.setOption1("Object Oriented Programming Language");
//		q.setOption2("a kind of coffee");
//		q.setOption3("A name of a island");
//		q.setOption4(" An interpreted language");
//		q.setOption5("None of them");
		q.setQuestionValue(5);
		QuestionsBank result = qc.insertQuestion(q);
		int value = result.getQuestionValue();
		assertEquals(5, value);
	}

}
