package com.virtualClass.App.service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualClass.App.model.Classschedule;
import com.virtualClass.App.repository.ClassscheduleRepository;

@Service
public class ClassscheduleService {

	@Autowired
	private ClassscheduleRepository classscheduleRepository;
	@Autowired
	private ClassesService classesService;

	public Classschedule saveOrUpdateClassSchedule(Classschedule classschedule) throws Exception {
		// classscheduleid, classId, weekday, starttime, endtime, year

		List<String> daysList = Arrays
				.asList(new String[] { "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday" });

		classschedule.setMessageStatus(false);
		int classId = -1;
		try {

			//classId = classschedule.getClasses().getClassid();

		} catch (NoSuchElementException e) {
			classId = -1;
		}

		if (classId == -1) {
			classschedule.setMessage("Invalid Class Id");
		} else if (daysList.contains(classschedule.getWeekday().trim().toLowerCase()) == false) {
			classschedule.setMessage("Invalid Week Day");
		} else if (CommonLogic.isLengthZeroOrNull(classschedule.getYear().trim())
				|| classschedule.getYear().trim().length() != 4 || CommonLogic.isNumeric(classschedule.getYear().trim()) == false) {
			classschedule.setMessage("Invalid Year");
		} else {
			classschedule = classscheduleRepository.save(classschedule);
			classschedule.setMessage("Save Successfully");
			classschedule.setMessageStatus(true);
		}

		return classschedule;
	}

	

}
