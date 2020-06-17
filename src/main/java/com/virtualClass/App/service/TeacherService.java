package com.virtualClass.App.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualClass.App.model.Student;
import com.virtualClass.App.model.Teacher;
import com.virtualClass.App.model.User;
import com.virtualClass.App.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private UserService userService;

	public Teacher saveOrUpdateTeacher(Teacher teacher) throws Exception {
		teacher.setMessageStatus(false);
		// Check NIC

		if (CommonLogic.isValidNic(teacher.getNic()) == false) {
			teacher.setMessage("Invalid NIC");
		}

		// Check Name
		else if (CommonLogic.isLengthZeroOrNull(teacher.getFname().trim())
				|| CommonLogic.isLengthZeroOrNull(teacher.getLname().trim())) {
			teacher.setMessage("Invalid Name");
			// Check Phone Number
		} else if (CommonLogic.isVaildGender(teacher.getGender()) == false) {
			teacher.setMessage("Invalid Gender");
		} else if (CommonLogic.isLengthZeroOrNull(teacher.getPhone().trim()) || teacher.getPhone().trim().length() != 10
				|| CommonLogic.isNumeric(teacher.getPhone().trim()) == false) {
			teacher.setMessage("Invalid Phone Number");
			// check Email
		} else if (CommonLogic.isValidEmail(teacher.getEmail().trim()) == false) {
			teacher.setMessage("Invalid Email");
		}
		// Save
		else {
			teacher = teacherRepository.save(teacher);
			teacher.setMessageStatus(true);
			// Create User - Save User

			try {
				if (userService.getUser(teacher.getNic().trim()).getUserid() != teacher.getNic().trim()) {
					User user = new User();
					user.setUserid(teacher.getNic().trim());
					user.setPassword(new String(userService.getGeneratePassword()));
					user.setUserrole("student");
					user.setIsactive(true);
					userService.saveOrUpdateUser(user);
				}
			} catch (NoSuchElementException ex) {
				User user = new User();
				user.setUserid(teacher.getNic().trim());
				user.setPassword(new String(userService.getGeneratePassword()));
				user.setUserrole("student");
				user.setIsactive(true);
				userService.saveOrUpdateUser(user);
			}

			return teacher;
		}
		return teacher;
	}

	public Teacher getTeacher(String nic) throws Exception {
		Teacher teacher;
		if (CommonLogic.isValidNic(nic.trim())) {
			teacher = teacherRepository.findById(nic).get();
			teacher.setMessage(null);
			teacher.setMessageStatus(true);
		} else {
			teacher = new Teacher();
			teacher.setMessage("Invalid NIC");
			teacher.setMessageStatus(false);
		}
		return teacher;
	}

	public Iterable<Teacher> getTeachers() throws Exception {
		
		
		
		return teacherRepository.findAll();
	}

}
