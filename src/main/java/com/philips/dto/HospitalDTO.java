package com.philips.dto;

public class HospitalDTO {

	private Long hospitalId;
	private String hospitalName;
	private String hospialDescription;
	private Long pid;
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospialDescription() {
		return hospialDescription;
	}
	public void setHospialDescription(String hospialDescription) {
		this.hospialDescription = hospialDescription;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
}
