package com.virtualClass.App.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentid;
	private int month;
	private int studentclassid;
	private boolean ispayment;
	private int year;

	//
	@Transient
	private String message;
	@Transient
	private boolean messageStatus;

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getStudentclassid() {
		return studentclassid;
	}

	public void setStudentclassid(int studentclassid) {
		this.studentclassid = studentclassid;
	}

	public boolean isIspayment() {
		return ispayment;
	}

	public void setIspayment(boolean ispayment) {
		this.ispayment = ispayment;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
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

}
