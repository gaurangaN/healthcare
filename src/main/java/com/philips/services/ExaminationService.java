package com.philips.services;
import java.util.List;

import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.dto.ExaminationDTO;
import com.philips.entity.Examination;
import com.philips.entity.Patient;
import com.philips.repo.ExaminationRepository;
import com.philips.repo.PatientRepository;
@Service
public class ExaminationService {
	@Autowired
	ExaminationRepository examinationRepository;

	@Autowired
	PatientRepository patientRepository;
	Examination exam = new Examination();
	JSONObject jsonObj = new JSONObject();

	public String add(ExaminationDTO examination) {
		// 1. check whether pid is valid
		try {
			Patient patientDetails = patientRepository.getOne(examination.getPid());
			if (patientDetails != null) {

				exam.setExaminationName(examination.getExaminationName());
				exam.setExaminationId(examination.getExaminationId());
				exam.setExaminationDate(examination.getExaminationDate());
				exam.setDescription(examination.getDescription());
				exam.setHeight(examination.getHeight());
				exam.setWeight(examination.getWeight());
				exam.setPatient(patientDetails);
				examinationRepository.save(exam);
				return "Added Successufully";
			} else {
				return "Error in adding Examination Details";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Pid not Found";
		}
	}

	public JSONObject get(long id) {
		
		try {
			
			List<Examination> ExaminationDetails = (List<Examination>) examinationRepository.findByPatientId(id);
			if(ExaminationDetails!=null) {
				for(Examination exmDetails :ExaminationDetails) {
					jsonObj.put("examinationId : ", exmDetails.getExaminationId());
					jsonObj.put("examinationName : ", exmDetails.getExaminationName());
					jsonObj.put("examinationDate : ", exmDetails.getExaminationDate());
					jsonObj.put("examinationDescription : ", exmDetails.getDescription());
					jsonObj.put("examinationHeight : ", exmDetails.getHeight());
					jsonObj.put("examinationWeight : ", exmDetails.getWeight());
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

	public JSONObject updateExaminationDetails(ExaminationDTO examinationDTO) {
		//1. pid check
		try {
		Patient patientDetails = patientRepository.getOne(examinationDTO.getPid());
		if(patientDetails!=null) {
			exam.setDescription(examinationDTO.getDescription());
			exam.setExaminationDate(examinationDTO.getExaminationDate());
			exam.setExaminationId(examinationDTO.getExaminationId());
			exam.setPatient(patientDetails);
			examinationRepository.save(exam);
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

	public JSONObject deleteExaminationDetails(ExaminationDTO examinationDTO) {
		
		if(examinationDTO!=null) {
			examinationRepository.deleteById(examinationDTO.getExaminationId());
			jsonObj.put("message", "Deleted Successfully");
			return jsonObj;
		}else {
			jsonObj.put("message", "failure in deletion");
			return jsonObj;
		}
	}
	

}
