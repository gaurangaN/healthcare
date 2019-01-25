package com.philips.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="patient")

public class Patient {

	@Id
	@Column(name="pid")
	
	//@GenericGenerator(name = "sequence_dep_id", strategy = "com.xyz.ids.DepartmentIdGenerator")
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Long pid;
	
	@Column(name="pname")
	private String pname;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="gender")
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
	public Patient() {
		
	}
	public Patient(Long pid, String pname, Date dob, char gender) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.dob = dob;
		this.gender = gender;
	}
	
}
