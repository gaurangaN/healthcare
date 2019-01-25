package com.philips.services;

import java.util.List;

import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.dto.HospitalDTO;
import com.philips.entity.Hospital;
import com.philips.entity.Patient;
import com.philips.repo.HospitalRepository;
import com.philips.repo.PatientRepository;

@Service
public class HospitalService {

	@Autowired
	HospitalRepository hospitalRepository;

	@Autowired
	PatientRepository patientRepository;

	/*
	 * @Autowired Patient patient;
	 */

	Hospital hospt = new Hospital();
	JSONObject jsonObj = new JSONObject();

	public String add(HospitalDTO hospital) {
		// 1. check whether pid is valid
		try {
			Patient patientDetails = patientRepository.getOne(hospital.getPid());
			if (patientDetails != null) {

				hospt.setHospialDescription(hospital.getHospialDescription());
				hospt.setHospitalId(hospital.getHospitalId());
				hospt.setHospitalName(hospital.getHospitalName());
				hospt.setPatient(patientDetails);
				hospitalRepository.save(hospt);
				return "Added Successufully";
			} else {
				return "Error in adding Hospital Details";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Pid not Found";
		}
	}

	public JSONObject get(long id) {
		
		try {
			
			List<Hospital> hospitalDetails = (List<Hospital>) hospitalRepository.findByPatientId(id);
			if(hospitalDetails!=null) {
				for(Hospital hptDetails :hospitalDetails) {
					jsonObj.put("hospitalId : ", hptDetails.getHospitalId());
					jsonObj.put("hospitaldesc : ", hptDetails.getHospialDescription());
					jsonObj.put("hospitalName : ", hptDetails.getHospitalName());
		
				}
				return jsonObj;
			}else {
				jsonObj.put("message : ", "no details found for the pid");
				return jsonObj;
			}
			
		}catch(Exception e) {
			jsonObj.put("error : ", "no details found for the pid");
			return jsonObj;
		}
	}

	public JSONObject updateHospitalDetails(HospitalDTO hospitalDTO) {
		//1. pid check
		try {
		Patient patientDetails = patientRepository.getOne(hospitalDTO.getPid());
		if(patientDetails!=null) {
			hospt.setHospialDescription(hospitalDTO.getHospialDescription());
			hospt.setHospitalId(hospitalDTO.getHospitalId());
			hospt.setHospitalName(hospitalDTO.getHospitalName());
			hospt.setPatient(patientDetails);
			hospitalRepository.save(hospt);
			jsonObj.put("message", "Updated Successfully");
			return jsonObj;
		}else {
			jsonObj.put("message", "Patient Id not found");
			return jsonObj;
		}
		}catch(Exception e) {
			jsonObj.put("message", "Error in updating");
			return jsonObj;
		}
		
	}

	public JSONObject deleteHospitalDetails(HospitalDTO hospitalDTO) {
		if(hospitalDTO!=null) {
			hospitalRepository.deleteById(hospitalDTO.getHospitalId());
			jsonObj.put("message", "Deleted Successfully");
			return jsonObj;
		}else {
			jsonObj.put("message", "failure in deletion");
			return jsonObj;
		}
			
	}

}
