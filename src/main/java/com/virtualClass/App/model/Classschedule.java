package com.virtualClass.App.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.MetaValue;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Classschedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classscheduleid;
	//
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name ="classid" , nullable = false)
	private Classes classes;
	
	
	//
	private String weekday;
	private String starttime;
	private String endtime;
	private String year;
	
	//
	@Transient
	private String message;
	@Transient
	private boolean messageStatus;
	public int getClassscheduleid() {
		return classscheduleid;
	}
	public void setClassscheduleid(int classscheduleid) {
		this.classscheduleid = classscheduleid;
	}

	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
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
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	
	

}
