package com.virtualClass.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.virtualClass.App.model.Studentclass;
import com.virtualClass.App.service.StudentClassService;

@RestController
@CrossOrigin
public class StudentClassController {
	
	@Autowired
	private StudentClassService studentClassService;
	
	@GetMapping("getStudentClassbyStudentId/{studentId}")
	public Iterable<Studentclass> getStudentClassbyStudentId(@PathVariable String studentId) {
		Iterable<Studentclass> studentclasses;
		try {
			studentclasses = studentClassService.getStudentClassbyStudentId(studentId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			studentclasses = null;
			
		}
		
		return studentclasses;
	}

}
