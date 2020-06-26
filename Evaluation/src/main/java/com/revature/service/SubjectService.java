package com.revature.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.Subject;
import com.revature.repo.SubjectRepository;

@Service
public class SubjectService {
	
	//Auto-wiring subject repository.
	@Autowired
	SubjectRepository sr;
	
	//Method to find all subjects
	public List<Subject> subjectList() {
		return sr.findAll();
	}
	
	//MEthod to fins subject by subject ID.
	public Subject findById(Long subjectId) {	
		return sr.findById(subjectId).get();
		
	}
	
	//Method to insert Subject into database.
	public String insertSubject(Subject s) {
		sr.save(s);
		return "{'message':'Subject added successfully.'}";
	}
	
	//Method to delete subject by subject ID.
	public String deleteSubjectById(Long subjectId) {
		sr.deleteById(subjectId);
		return "{'message':'Subject deleted successfully.'}";
	}


}
