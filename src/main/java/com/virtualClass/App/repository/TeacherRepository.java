package com.virtualClass.App.repository;

import org.springframework.data.repository.CrudRepository;

import com.virtualClass.App.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, String> {

}
