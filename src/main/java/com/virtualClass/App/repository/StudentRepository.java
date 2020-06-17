package com.virtualClass.App.repository;

import org.springframework.data.repository.CrudRepository;

import com.virtualClass.App.model.Student;

public interface StudentRepository extends CrudRepository<Student, String> {

}
