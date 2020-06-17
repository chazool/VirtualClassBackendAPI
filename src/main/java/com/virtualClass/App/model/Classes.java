package com.virtualClass.App.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "classes")
public class Classes implements Serializable {
	// private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classid;
	private String classname;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "teacherid", nullable = false)
	private Teacher teacher;

	@OneToMany(mappedBy = "classes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Classschedule> classschedules;

	@OneToMany(mappedBy = "Classes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Studentclass> Studentclass;

	//
	@Transient
	private String message;

	@Transient
	private boolean messageStatus;

	public int getClassid() {
		return classid;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
	/*
	 * public String getTeacherid() { return teacherid; }
	 * 
	 * public void setTeacherid(String teacherid) { this.teacherid = teacherid; }
	 */

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

	public List<Classschedule> getClassschedules() {
		return classschedules;
	}

	public void setClassschedules(List<Classschedule> classschedules) {
		this.classschedules = classschedules;
	}

}
