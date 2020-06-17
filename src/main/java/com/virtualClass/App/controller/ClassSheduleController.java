package com.virtualClass.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtualClass.App.model.Classschedule;
import com.virtualClass.App.service.ClassscheduleService;

@RestController
@CrossOrigin
public class ClassSheduleController {

	@Autowired
	private ClassscheduleService classscheduleService;

	@PostMapping("/SaveClassShedule")
	public Classschedule SaveClassShedule(@RequestBody Classschedule classschedule) {

		try {
			classschedule = classscheduleService.saveOrUpdateClassSchedule(classschedule);
		} catch (Exception e) {
			e.printStackTrace();
			classschedule.setMessage(e.getMessage());
			classschedule.setMessageStatus(false);
		}

		return classschedule;
	}

	

}
