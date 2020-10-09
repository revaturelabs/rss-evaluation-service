package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import com.revature.entity.Quiz;
import com.revature.entity.Subject;
import com.revature.service.QuizService;

@SpringBootTest
public class EvalAppTestMockitoQS {

	private static Subject subject;
	private static Quiz quiz;
	
	QuizService quizService = Mockito.mock(QuizService.class);
		
	@BeforeClass
	public void initialize() throws Exception {
		subject = new Subject((long)2,"Test");
		quiz = new Quiz((long)1, "Java Bean", "description", 100, "Easy", 3, "test@rev.com", (long)2, subject);
	}
	
	/** Test Methods in QuizService **/
	
	@Test
	public void findQuizBySubjectTest() {	
		when(quizService.findQuizBySubject(2)).thenReturn(Stream
				.of(new Quiz()).collect(Collectors.toList()));
		
		assertEquals(1, quizService.findQuizBySubject(2).size());
	}
	
	@Test
	public void findByIdTest() {
	
		Quiz quiz1 = quizService.findById((long)1);
		
		assertEquals(quiz, quiz1);
	}
	
	@Test 
	void insertQuizTest() {
		
		when(quizService.insertQuiz(quiz)).thenReturn(quiz);
		assertEquals(quiz, quizService.insertQuiz(quiz));		
	}	
	
	@Test
	public void deleteQuizByIdTest() {
		
		quizService.deleteQuizById((long) 1);
		verify(quizService,times(1)).deleteQuizById((long)1);	
	}
	
	@Test
	public void getAllQuizzesTest() {

		when(quizService.getAllQuizzes()).thenReturn(Stream
				.of(quiz).collect(Collectors.toList()));
		
		assertEquals(1, quizService.getAllQuizzes().size());
	}
	
}
