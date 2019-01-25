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

import com.philips.dto.ExaminationDTO;
import com.philips.services.ExaminationService;

@RestController
public class ExaminationController {
	@Autowired
	ExaminationService examinationService;
	
	@RequestMapping(method = RequestMethod.POST,value = "/examination/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addExaminationDetails(@RequestBody ExaminationDTO examinationDTO){
			
		String message = examinationService.add(examinationDTO);
		//return message;
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("message : ", message);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
		
	}
	@RequestMapping(method = RequestMethod.POST,value = "/examination/retrieve/{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSONObject> getExaminationDetails(@PathVariable long pid){
			
		JSONObject hospitalDetails = examinationService.get(pid);
		//return message;.0
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("message : ", hospitalDetails);
		return new ResponseEntity<JSONObject>(jsonObj,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/examination/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSONObject> updateExaminationDetails(@RequestBody ExaminationDTO examinationDTO){
			
		JSONObject examinationDetails = examinationService.updateExaminationDetails(examinationDTO);
		//return message;
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("message : ", examinationDetails);
		return new ResponseEntity<JSONObject>(jsonObj,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/examination/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSONObject> deleteExaminationDetails(@RequestBody ExaminationDTO examinationDTO){
			
		JSONObject examinationDetails = examinationService.deleteExaminationDetails(examinationDTO);
		//return message;
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("message : ", examinationDetails);
		return new ResponseEntity<JSONObject>(jsonObj,HttpStatus.CREATED);
		
	}
}
