package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.revature.entity.Quiz;
import com.revature.entity.Subject;
import com.revature.repo.QuizRepository;
import com.revature.repo.SubjectRepository;
import com.revature.service.QuizService;
import com.revature.service.SubjectService;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
class EvaluationApplicationTestsMockito {
	
	@Autowired
	private SubjectService subjectService;	
	@Autowired
	private QuizService quizService;
		
	
	@MockBean
	private SubjectRepository subjectRepo;
	@MockBean
	private QuizRepository quizRepo;
	
	
	// Mockito Tests
	
	/** Test Methods in SubjectService **/
	
	@Test
	public void getSubjectList() {
		Subject subject = new Subject((long)1, "Java");

		when(subjectRepo.findAll()).thenReturn(Stream
				.of(subject).collect(Collectors.toList()));
		
		assertEquals(1, subjectService.subjectList().size());
	}
	
	@Test 
	void insertSubjectTest() {
		Subject subject = new Subject((long)2,"Test");
		
		when(subjectRepo.save(subject)).thenReturn(subject);
		assertEquals("{'message':'Subject added successfully.'}", subjectService.insertSubject(subject));		
	}
	
	@Test
	public void deleteSubjectById() {
		Subject subject = new Subject((long)3, "Delete");
		
		subjectService.deleteSubjectById((long)3);
		verify(subjectRepo,times(1)).deleteById((long)3);
	}

	
	/** Test Methods in QuizService **/
	
	@Test
	public void getQuizListTest() {
		Subject subject = new Subject((long)2,"Test");
		Quiz quiz = new Quiz((long)1, "Java Bean", " ", "test@rev.com", (long)2, subject);

		when(quizRepo.findAll()).thenReturn(Stream
				.of(quiz).collect(Collectors.toList()));
		
		assertEquals(1, quizService.quizList().size());
	}
	
	
	@Test
	public void getQuizBySubject() {
		Subject subject = new Subject((long)2,"Test");
		Quiz quiz = new Quiz((long)1, "Java Bean", " ", "test@rev.com", (long)2, subject);
		
		when(quizRepo.findQuizBySubject(subject)).thenReturn(Stream
				.of(new Quiz()).collect(Collectors.toList()));
		
		assertEquals(1, quizService.findQuizBySubject(1).size());
	}
	
	@Test
	public void deleteQuizByIdTest() {
		Subject subject = new Subject((long)2,"Test");
		Quiz quiz = new Quiz((long)1, "Java Bean", " ", "test@rev.com", (long)2, subject);
		
		quizService.deleteQuizById((long) 1);
		verify(quizRepo,times(1)).deleteById((long)1);
		
	}
	


}
