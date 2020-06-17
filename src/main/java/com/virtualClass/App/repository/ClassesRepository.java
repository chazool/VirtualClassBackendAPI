package com.virtualClass.App.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.virtualClass.App.model.Classes;
import com.virtualClass.App.model.Teacher;

public interface ClassesRepository extends CrudRepository<Classes, Integer> {

//	@Query("SELECT c from Classes c where c.teacherid = :teacherid ")
//	public  Iterable<Classes> findbyTeacherId(@Param("teacherid") final String teacherid);/	
//Class findByClass(Integer classid);findByName	
//	List<Classes> findByTeacher( Teacher  teacher);	
	
	List<Classes> findByTeacherNic(String teacherid);

	List<Classes> findByTeacherFname(String fname);

	List<Classes> findByTeacherLnameOrTeacherFnameOrClassname(String lname, String fname, String classname);
	
	Classes findByClassid(int classid);
	

}
