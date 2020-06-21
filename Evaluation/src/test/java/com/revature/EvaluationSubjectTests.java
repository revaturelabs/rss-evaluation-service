package com.revature;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.revature.controller.SubjectController;
import com.revature.entity.Subject;

@SpringBootTest
class EvaluationSubjectTests {

	@Autowired
	SubjectController sc;
	
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
