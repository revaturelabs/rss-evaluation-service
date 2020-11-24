package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import com.revature.entity.Option;
import com.revature.entity.QuestionsBank;
import com.revature.entity.Quiz;
import com.revature.entity.Subject;
import com.revature.service.QuestionsBankService;

@SpringBootTest
public class EvalAppTestMockitoQBS {
	
	private static Quiz quiz;
	private static Subject subject;
	private static QuestionsBank qb;
	
	QuestionsBankService qbsService = Mockito.mock(QuestionsBankService.class);
	
	@BeforeClass
	public void initialize() throws Exception {
		subject = new Subject((long)2,"Test");
		quiz = new Quiz((long)1, "Java Bean", "description", 100, "Easy", "test@rev.com", (long)2, subject);
		
		qb = new QuestionsBank();
		qb.setQuestionId((long)1);
		qb.setQuestionValue(5);
		qb.setQuestion("Test");
		//TODO: create a list of options and to it then set it with setter
		List<Option> options = new ArrayList<Option>();
		Option opt1 = new Option();
		Option opt2 = new Option();
		options.add(opt1);
		options.add(opt2);
//		qb.setOption1("option1");
//		qb.setOption2("option2");
		qb.setQuiz(quiz);
	}
	
	
	/** Test Methods in QuestionsBankService **/
	
	@Test
	public void findAllQuestionsTest() {

		when(qbsService.findAllQuestions()).thenReturn(Stream
				.of(new QuestionsBank()).collect(Collectors.toList()));
		
		assertEquals(1, qbsService.findAllQuestions().size());

	}

//	@Test
//	public void findQuestionsByQuizTest() {
//		
//		when(qbsService.findQuestionsByQuiz(qb)).thenReturn(Stream
//				.of(new QuestionsBank()).collect(Collectors.toList()));
//		
//		assertEquals(1, qbsService.findQuestionsByQuiz(qb).size());
//	}
	
	@Test
	public void getQuestionTest(){	
		QuestionsBank qb1 = qbsService.getQuestion((long)1);
		
		assertEquals(qb, qb1);	
	}
	
	@Test
	public void insertQuestionTest() {	
		
		when(qbsService.InsertQuestion(qb)).thenReturn(qb);
		assertEquals(qb, qbsService.InsertQuestion(qb));
	}
	
}
