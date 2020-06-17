 package com.virtualClass.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.virtualClass.App.model.Teacher;
import com.virtualClass.App.service.TeacherService;

@RestController
@CrossOrigin
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	@PostMapping("/saveTeacher")
	public Teacher saveTeacher(@RequestBody Teacher teacher) {

		try {
			teacher = teacherService.saveOrUpdateTeacher(teacher);
			if (teacher.isMessageStatus()) {
				teacher.setMessage("Save Successfully");
			}
			
			return teacher;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// set Message
			teacher.setMessage(e.getMessage());
			return teacher;
		}
	}

	@PutMapping("/updateTeacher")
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		try {
			teacher = teacherService.saveOrUpdateTeacher(teacher);
			if (teacher.isMessageStatus()) {
				teacher.setMessage("Update Successfully");
			}
			
			
			return teacher;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// set Message
			teacher.setMessage(e.getMessage());
			teacher.setMessageStatus(false);
			return teacher;
		}
	}

	@GetMapping("/getTeacher/{nic}")
	public Teacher getTeacher(@PathVariable String nic) {
		try {
			return teacherService.getTeacher(nic);
		} catch (Exception e) {
			
			e.printStackTrace();
			// set Message
			Teacher teacher= new Teacher();
			teacher.setMessage(e.getMessage());
			teacher.setMessageStatus(false);
			return teacher;
		}
	}

	@GetMapping("/getTeachers")
	public Iterable<Teacher> getTeachers() {
		Iterable<Teacher> teachers;
		try {
			
			
			teachers = teacherService.getTeachers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// set Message
			teachers = null;
		}

		return teachers;
	}

}
