package com.philips.dto;

import java.sql.Date;

public class ExaminationDTO {

	
	private Long examinationId;
	private Date examinationDate;
	private String examinationName;
	private String description;
	private String weight;
	private String height;
	private Long pid;
	
	
	public  ExaminationDTO()
	{
		
	}
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
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
}
