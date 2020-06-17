package com.virtualClass.App.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.virtualClass.App.model.Student;
import com.virtualClass.App.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student student) {

		try {
			student = studentService.saveOrUpdateStudent(student);
			if (student.isMessageStatus()) {
				student.setMessage("Save Successfully");
			}

			return student;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// set Message
			student.setMessage(e.getMessage());
			return student;
		}
	}

	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		try {
			student = studentService.saveOrUpdateStudent(student);
			if (student.isMessageStatus()) {
				student.setMessage("Update Successfully");
			}

			return student;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// set Message
			student.setMessage(e.getMessage());
			student.setMessageStatus(false);
			return student;
		}
	}

	@GetMapping("/getStudent/{nic}")
	public Student getStudent(@PathVariable String nic) {
		try {
			/*
			 * RequestAttributes requestAttributes =
			 * RequestContextHolder.currentRequestAttributes(); ServletRequestAttributes
			 * attributes = (ServletRequestAttributes) requestAttributes; HttpServletRequest
			 * request = attributes.getRequest(); HttpSession httpSession =
			 * request.getSession(true); // HttpSession session = request.getSession();
			 */
			//
			Student student = studentService.getStudent(nic);
			// String u =session.getAttribute("UserName").toString();
			// student.setMessage(u);
			return student;
		} catch (Exception e) {

			e.printStackTrace();
			// set Message
			Student student = new Student();
			student.setMessage(e.getMessage());
			student.setMessageStatus(false);
			return student;
		}
	}

	@GetMapping("/getStudents")
	public Iterable<Student> getStudents() {
		Iterable<Student> students;
		try {
			// Session

//			RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
//			ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
//			HttpServletRequest request = attributes.getRequest();
//			HttpSession httpSession = request.getSession(true);

			// httpSession.setAttribute("UserName", "Chazool Kaweesha");

			students = studentService.getStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// set Message
			students = null;
		}

		return students;
	}

}
