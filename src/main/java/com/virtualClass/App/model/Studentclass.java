package com.virtualClass.App.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Studentclass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentclassid;
	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "studentid" ,nullable = false)
	private Student student;
	
	
	@JsonIgnore
	@ManyToOne(fetch =FetchType.LAZY, optional = false)
	@JoinColumn(name ="classid" , nullable = false)
	private Classes Classes;
	
	
	@Transient
	private String message;
	@Transient
	private boolean messageStatus;
	public int getStudentclassid() {
		return studentclassid;
	}
	public void setStudentclassid(int studentclassid) {
		this.studentclassid = studentclassid;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(boolean messageStatus) {
		this.messageStatus = messageStatus;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Classes getClasses() {
		return Classes;
	}
	public void setClasses(Classes classes) {
		Classes = classes;
	}
	
	

}
