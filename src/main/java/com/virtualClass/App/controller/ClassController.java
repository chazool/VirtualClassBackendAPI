package com.virtualClass.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtualClass.App.model.Classes;
import com.virtualClass.App.model.Teacher;
import com.virtualClass.App.service.ClassesService;

@RestController
@CrossOrigin
public class ClassController {

	@Autowired
	private ClassesService classesService;

	@PostMapping("/saveClasses/{teachernic}")
	public Classes saveClassess(@RequestBody Classes classes, @PathVariable String teachernic) {
		try {
			classes.setTeacher(new Teacher());
			classes.getTeacher().setNic(teachernic);
			classes = classesService.saveAndUpdateClasses(classes);

			if (classes.isMessageStatus()) {
				classes.setMessage("Saved Successfully");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			classes.setMessage(e.getMessage());
			classes.setMessageStatus(false);
		}

		return classes;
	}

	@GetMapping("/getClasses/{classId}")
	public Classes getClasses(@PathVariable int classId) {
		Classes classes;
		try {
			classes = classesService.getClasses(classId);
			classes.setMessageStatus(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			classes = new Classes();
			classes.setMessage(e.getMessage());
			classes.setMessageStatus(false);
		}

		return classes;
	}

	@GetMapping("/getClasses")
	public Iterable<Classes> getClasses() {
		Iterable<Classes> classes;
		try {
			classes = classesService.getAllClasses();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			classes = null;
		}

		return classes;
	}

	@GetMapping("/getClassesByTeacherId/{teacherId}")
	public Iterable<Classes> getClassesByTeacherId(@PathVariable String teacherId) {
		Iterable<Classes> classes = null;
		try {
			classes = classesService.getClassesByTeacherId(teacherId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			classes = null;
		}

		return classes;

	}

}
