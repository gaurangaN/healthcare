package com.philips.controller;




import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.dto.PatientDTO;
import com.philips.entity.Patient;
import com.philips.services.PatientService;






@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	
	@RequestMapping(method = RequestMethod.POST,value = "/patient/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPatientDetails(@RequestBody PatientDTO patient){
		System.out.println("data is coming:");
		
		String message = patientService.add(patient);
		//return message;
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("message : ", message);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
		
	}
	@RequestMapping(method = RequestMethod.POST,value = "/patient/get/{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSONObject> getPatientDetails(@PathVariable long pid){
		Patient patientDetails = patientService.getPatientDetailsById(pid);
		
		//return message;
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("pid : ", patientDetails.getPid());
		jsonObj.put("pname : ", patientDetails.getPname());
		jsonObj.put("dob : ", patientDetails.getDob());
		jsonObj.put("gender : ", patientDetails.getGender());
		return new ResponseEntity<JSONObject>(jsonObj,HttpStatus.FOUND);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/patient/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSONObject> updatePatientDetails(@RequestBody PatientDTO patient){
		
		String message = patientService.updatePatientDetails(patient);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("Message : ", message);
		return new ResponseEntity<JSONObject>(jsonObj,HttpStatus.ACCEPTED);
		
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/patient/delete/{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSONObject> deletePatientDetails(@PathVariable long pid){
		
		String message = patientService.deletePatientDetails(pid);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("Message : ", message);
		return new ResponseEntity<JSONObject>(jsonObj,HttpStatus.ACCEPTED);
		
		
	}
}
