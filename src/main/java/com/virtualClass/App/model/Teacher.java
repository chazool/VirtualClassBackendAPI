package com.virtualClass.App.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="teacher") 
public class Teacher  implements Serializable {

	 private static final long serialVersionUID = 1L;
	 
	@Id
	private String nic;
	private String fname;
	private String lname;
	private String phone;
	private String email;
	private String zoommeetingid;
	private String zoommeetingpassword;
	private boolean isactive;
	private String gender;
	//
	
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Classes> classes;
	
	
	public Set<Classes> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}

	
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

	public String getZoommeetingid() {
		return zoommeetingid;
	}

	public void setZoommeetingid(String zoommeetingid) {
		this.zoommeetingid = zoommeetingid;
	}

	public String getZoommeetingpassword() {
		return zoommeetingpassword;
	}

	public void setZoommeetingpassword(String zoommeetingpassword) {
		this.zoommeetingpassword = zoommeetingpassword;
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
