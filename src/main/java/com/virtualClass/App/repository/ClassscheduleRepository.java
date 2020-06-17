package com.virtualClass.App.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.virtualClass.App.model.Classschedule;

public interface ClassscheduleRepository extends CrudRepository<Classschedule, Integer> {

//	@Query("SELECT c FROM Classschedule c WHERE c.classid= :classId" )
//	 public Iterable<Classschedule> getClassSheduleByClassId(@Param("classId") int classId);
//	
	//
	//@Query("SELECT c from Classes c where c.teacherid = :teacherid ")
	//public  Iterable<Classes> getClassesByTeacherId(@Param("teacherid") String teacherId);

	
	
	
}
