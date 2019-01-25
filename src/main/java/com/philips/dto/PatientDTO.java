package com.philips.dto;

import java.sql.Date;

public class PatientDTO {

	public PatientDTO(Long pid, String pname, Date dob, char gender) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.dob = dob;
		this.gender = gender;
	}
	private Long pid;
	private String pname;
	private Date dob;
	private char gender;
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public PatientDTO() {
		
	}
}
