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

import com.revature.entity.Subject;
import com.revature.service.SubjectService;

@SpringBootTest
public class EvalAppTestMockitoSS {

	private static Subject subject;
	
	SubjectService subjectService = Mockito.mock(SubjectService.class);
	
	@BeforeClass
	public void initialize() throws Exception {
		subject = new Subject((long)2,"Test");
	}
	
	/** Test Methods in SubjectService **/
	
	@Test
	public void subjectListTest() {

		when(subjectService.subjectList()).thenReturn(Stream
				.of(subject).collect(Collectors.toList()));
		
		assertEquals(1, subjectService.subjectList().size());
	}
	
	@Test
	public void findByIdTest() {
		
		Subject subject1 = subjectService.findById((long)2);
		
		assertEquals(subject, subject1);	
	}
	
	@Test 
	void insertSubjectTest() {
		String s = "{'message':'Subject added successfully.'}";
		
		when(subjectService.insertSubject(subject)).thenReturn(s);
		assertEquals("{'message':'Subject added successfully.'}", subjectService.insertSubject(subject));		
	}
	
	@Test
	public void deleteSubjectById() {
		
		subjectService.deleteSubjectById((long)3);
		verify(subjectService,times(1)).deleteSubjectById((long)3);
	}
	
}
