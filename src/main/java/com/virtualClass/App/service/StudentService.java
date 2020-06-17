package com.virtualClass.App.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualClass.App.model.Student;
import com.virtualClass.App.model.User;
import com.virtualClass.App.repository.StudentRepository;
import com.virtualClass.App.repository.UserRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private UserService userService;

	public Student saveOrUpdateStudent(Student student) throws Exception {
		student.setMessageStatus(false);
		// Check NIC

		if (CommonLogic.isValidNic(student.getNic()) == false) {
			student.setMessage("Invalid NIC");
		}
		// Check Name
		else if (CommonLogic.isLengthZeroOrNull(student.getFname().trim())
				|| CommonLogic.isLengthZeroOrNull(student.getLname().trim())) {
			student.setMessage("Invalid Name");
			// Check Phone Number
		} else if (CommonLogic.isVaildGender(student.getGender()) == false) {
			student.setMessage("Invalid Gender");
		} else if (CommonLogic.isLengthZeroOrNull(student.getPhone().trim()) || student.getPhone().trim().length() != 10
				|| CommonLogic.isNumeric(student.getPhone().trim()) == false) {
			student.setMessage("Invalid Phone Number");
			// check Email
		} else if (CommonLogic.isValidEmail(student.getEmail().trim()) == false) {
			student.setMessage("Invalid Email");
		}
		// Save
		else {
			// Save Student
			student = studentRepository.save(student);
			student.setMessageStatus(true);
			// Create User - Save User

			try {
				if (userService.getUser(student.getNic().trim()).getUserid() != student.getNic().trim()) {

					User user = new User();
					user.setUserid(student.getNic().trim());
					user.setPassword(new String(userService.getGeneratePassword()));
					user.setUserrole("student");
					user.setIsactive(true);

					userService.saveOrUpdateUser(user);
				}
			} catch (NoSuchElementException ex) {
				User user = new User();
				user.setUserid(student.getNic().trim());
				user.setPassword(new String(userService.getGeneratePassword()));
				user.setUserrole("student");
				user.setIsactive(true);

				userService.saveOrUpdateUser(user);
			}

			return student;
		}

		return student;
	}

	public Student getStudent(String nic) throws Exception {
		Student student;
		if (CommonLogic.isValidNic(nic.trim())) {
			student = studentRepository.findById(nic).get();
			student.setMessage(null);
			student.setMessageStatus(true);

		} else {
			student = new Student();
			student.setMessage("Invalid NIC");
			student.setMessageStatus(false);

		}

		return student;
	}

	public Iterable<Student> getStudents() throws Exception {

		return studentRepository.findAll();
	}

}
