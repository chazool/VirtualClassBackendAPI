package com.virtualClass.App.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.virtualClass.App.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

	/*
	@Query(value = "SELECT p FROM Payment p where year= :year and month= :month and classid=:classid")
	public Iterable<Payment> findByYearMothAndClassId(@Param("year") int year, @Param("month") int month,
			@Param("classid") int classid);

	@Query(value = "SELECT p FROM Payment where  year=:year and month= :month and studentnic :studentnic")
	public Iterable<Payment> findByYearMonthAndStudentId(@Param("year") int year, @Param("month") int month,
			@Param("studentnic") String studentId);

	@Query(value = "SELECT p FROM Payment where  year=:year and month= :month and classid=:classid and studentnic=:studentnic")
	public Payment findByYearMonthClassIdAndStudentId(@Param("year") int year, @Param("month") int month,
			@Param("classid") int classid, @Param("studentnic") String studentId);

*/
}
