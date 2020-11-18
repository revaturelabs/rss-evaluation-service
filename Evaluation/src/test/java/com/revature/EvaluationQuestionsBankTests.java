package com.revature;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.revature.controller.QuestionsBankController;
import com.revature.entity.Option;
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
		List<Option> options = new ArrayList<Option>();
		Option opt1 = new Option();
		Option opt2 = new Option();
		options.add(opt1);
		options.add(opt2);
		q.setOptions(options);
		q.setQuestionValue(5);
		QuestionsBank result = qc.insertQuestion(q);
		int value = result.getQuestionValue();
		assertEquals(5, value);
	}

}
