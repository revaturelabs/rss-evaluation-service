package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.Subject;
import com.revature.repo.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	SubjectRepository sr;
	
	public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<Subject>();
        sr.findAll().forEach(subject -> subjects.add(subject));
        return subjects;
    }
	
	public String insertSubject(Subject s) {
		sr.save(s);
		return "Subject successfully added";
	}
}
