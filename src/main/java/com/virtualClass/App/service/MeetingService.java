package com.virtualClass.App.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualClass.App.model.Classes;
import com.virtualClass.App.model.Meeting;
import com.virtualClass.App.model.Payment;
import com.virtualClass.App.model.Student;
import com.virtualClass.App.model.Teacher;
@Service
public class MeetingService {

	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ClassesService classesService;
	@Autowired
	private PaymentService paymentService;

	public Meeting startMetting(String studentId, int classId) throws Exception {
		

		// Student Details
		Student student = studentService.getStudent(studentId);

		// get Class Data
		Classes classes = classesService.getClasses(classId);

		// get Teacher Data
	//	Teacher teacher = teacherService.getTeacher(classes.getTeacherid().trim());
		
		Teacher teacher = teacherService.getTeacher("null");
		
		Meeting meeting = new Meeting();
		meeting.setStudentName(student.getFname()+" "+student.getLname());
		meeting.setStudentNic(student.getNic());
		meeting.setZoomMeetingId(teacher.getZoommeetingid().trim());
		meeting.setZoomMeetingPassword(teacher.getZoommeetingpassword().trim());
		meeting.setMessageStatus(true);

		return meeting;
	}

}
