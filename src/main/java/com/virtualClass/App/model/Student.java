package com.virtualClass.App.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Student {
	
	@Id
	private String nic;
	private String fname;
	private String lname;
	private String phone;
	private String email;
	private boolean isactive;
	private String gender;
	
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	private List<Studentclass> Studentclass;
	
	
	//
	@Transient
	private String message;
	@Transient
	private boolean messageStatus;
	
	
	
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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

	
	
	
	
	
	
	
	
	
	
	
	


