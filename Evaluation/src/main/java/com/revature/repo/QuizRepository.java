package com.revature.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.revature.entity.Quiz;
import com.revature.entity.Subject;

public interface QuizRepository extends JpaRepository<Quiz, Long>, CrudRepository<Quiz, Long> {
	
	public List<Quiz> findQuizBySubject(Subject subject);
	

	
	
	// public List<Quiz> findQuizBySubjectId(long id);
		
}


