package com.philips.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="examination")
public class Examination {
	@Id
	@Column(name="examinationId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long examinationId;
	
	@Column(name="examinationDate")
	private Date examinationDate;
	
	@Column(name="examinationName")
	private String examinationName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="weight")
	private String weight;
	
	@Column(name="height")
	private String height;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "pid", nullable = false)
	private Patient patient;
	public Long getExaminationId() {
		return examinationId;
	}
	
	
	public void setExaminationId(Long examinationId) {
		this.examinationId = examinationId;
	}
	public Date getExaminationDate() {
		return examinationDate;
	}
	public void setExaminationDate(Date examinationDate) {
		this.examinationDate = examinationDate;
	}
	public String getExaminationName() {
		return examinationName;
	}
	public void setExaminationName(String examinationName) {
		this.examinationName = examinationName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public Examination(Long examinationId, Date examinationDate, String examinationName, String description,
			String weight, String height) {
		super();
		this.examinationId = examinationId;
		this.examinationDate = examinationDate;
		this.examinationName = examinationName;
		this.description = description;
		this.weight = weight;
		this.height = height;
	}
	public Examination(){
		
	}

	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
