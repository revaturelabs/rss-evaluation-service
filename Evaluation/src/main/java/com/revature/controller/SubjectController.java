package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.entity.Subject;
import com.revature.service.SubjectService;

public class SubjectController {
	
	@Autowired
    SubjectService ss;
	
	@GetMapping("/subjects")
    private List<Subject> getAllSubjects() {
        return ss.getAllSubjects();
    }
}
