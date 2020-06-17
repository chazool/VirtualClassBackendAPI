package com.virtualClass.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualClass.App.model.Payment;
import com.virtualClass.App.model.Studentclass;
import com.virtualClass.App.repository.StudentClassRepository;

@Service
public class StudentClassService {
	
	@Autowired
	private StudentClassRepository studentClassRepository;
	
	
	
	
	public Iterable<Studentclass> getStudentClassbyStudentId(String studentId) throws Exception {
		return studentClassRepository.findAll();
	}




	public Studentclass getStudentClass(int studentclassid) {
		// TODO Auto-generated method stub
		return studentClassRepository.findById(studentclassid).get();
	}

}
