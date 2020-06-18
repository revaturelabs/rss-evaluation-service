package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.revature.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>, CrudRepository<Subject, Long> {
	
	
}