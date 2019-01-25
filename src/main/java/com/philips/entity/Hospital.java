package com.philips.entity;



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
@Table(name="hospital")
public class Hospital {

	@Id
	@Column(name="hospitalId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long hospitalId;
	
	@Column(name="hospitalName")
	private String hospitalName;
	
	@Column(name="hospialDescription")
	private String hospialDescription;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "pid", nullable = false)
	private Patient patient;
	
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
	public Hospital() {
		
	}
	public Hospital(Long hospitalId, String hospitalName, String hospialDescription) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.hospialDescription = hospialDescription;
	}
	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
