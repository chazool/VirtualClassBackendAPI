package com.virtualClass.App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualClass.App.model.Classes;
import com.virtualClass.App.model.Teacher;
import com.virtualClass.App.repository.ClassesRepository;
import com.virtualClass.App.repository.TeacherRepository;

@Service
public class ClassesService {

	@Autowired
	private ClassesRepository classesRepository;
	@Autowired
	private TeacherService teacherService;

	public Classes saveAndUpdateClasses(Classes classes) throws Exception {
		classes.setMessageStatus(false);
		if (CommonLogic.isLengthZeroOrNull(classes.getClassname())) {
			classes.setMessage("Invalid Class Name");
		}
		
		  else if (CommonLogic.isValidNic(classes.getTeacher().getNic().trim()) == false) {
		  classes.setMessage("Invalid Teacher NIC"); } else if
		  (!teacherService.getTeacher(classes.getTeacher().getNic().trim()).getNic()
		  .equals(classes.getTeacher().getNic().trim())) {
		  classes.setMessage("Teacher not Available"); }
		 

		else

		{
			classes = classesRepository.save(classes);
			classes.setMessage("Saved Successfully");
			classes.setMessageStatus(true);
		}

		return classes;
	}

	public Classes getClasses(int classId) throws Exception {

		return classesRepository.findById(classId).get();

	}

	public Iterable<Classes> getAllClasses() throws Exception {

		return classesRepository.findAll();

	}

	public List<Classes> getClassesByTeacherId(String teacherId) throws Exception {
		
		return classesRepository.findByTeacherNic(teacherId);

	}

}
