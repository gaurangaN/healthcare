package com.philips.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.philips.dto.PatientDTO;
import com.philips.entity.Patient;
import com.philips.repo.PatientRepository;


@Service
public class PatientService {

	@Inject
	PatientRepository patientRepository;

	/*
	 * @Autowired Patient patient;
	 */

	Patient patient = new Patient();

	public String add(PatientDTO patientDto) {

		if (patient != null) {
			// patient.setPid(patientDto.getPid());
			patient.setPname(patientDto.getPname());
			patient.setDob(patientDto.getDob());
			patient.setGender(patientDto.getGender());
			patientRepository.save(patient);
			return "successfully added";
		} else {
			return "Not added successfully";
		}
	}

	public Patient getPatientDetailsById(long pid) {
		Patient patientDetails = patientRepository.getOne(pid);
		if (patientDetails != null) {
			return patientDetails;
		} else {
			return patientDetails;
		}
	}

	public String updatePatientDetails(PatientDTO patientDetails) {
		if (patientDetails != null) {
			Patient patientGetDetails = patientRepository.getOne(patientDetails.getPid());
			patientGetDetails.setDob(patientDetails.getDob());
			patientGetDetails.setGender(patientDetails.getGender());
			patientGetDetails.setPname(patientDetails.getPname());

			patientRepository.save(patientGetDetails);
			return "Updated Successfully";
		} else {
			return "Error in Updation";
		}
	}

	public String deletePatientDetails(long pid) {
		try {
		Patient patientDetails = patientRepository.getOne(pid);
		if(patientDetails!=null) {
			patientRepository.delete(patientDetails);
			return "Deleted Successfully";
		}else {
			return "Error in Deletion";
		}
		}catch(Exception e) {
			return "Id not found";
		}
		
		
	}

	/*
	 * public Patient addPatient(Patient patient) { return
	 * patientRepository.save(patient);
	 * 
	 * }
	 */

}
