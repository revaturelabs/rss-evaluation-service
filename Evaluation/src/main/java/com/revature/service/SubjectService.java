package com.revature.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.Subject;
import com.revature.repo.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	SubjectRepository sr;
	
	public List<Subject> subjectList() {
		return sr.findAll();
	}

	public Subject findById(Long id) {	
		return sr.findById(id).get();
		
	}

	public String insertSubject(Subject s) {
		sr.save(s);
		return "{'message':'Subject added successfully.'}";
	}

	public String deleteSubjectById(Long id) {
		sr.deleteById(id);
		return "{'message':'Subject deleted successfully.'}";
	}


}
