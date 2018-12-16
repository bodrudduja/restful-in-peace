package com.rokomari.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rokomari.beans.Patient;
import com.rokomari.services.PatientService;

//@RestController
public class PatientController {
/*
	@Autowired
	private PatientService service;

	@RequestMapping(value = "/api/patients", method = RequestMethod.GET)
	public List<Patient> getAllPatients(@RequestHeader String token, @RequestHeader String jwt_token) {
		List<Patient> addressList = service.getAllPatients();
		return addressList;
	}

	@RequestMapping(value = "/api/patients", method = RequestMethod.GET)
	public Patient getPatientById(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestHeader Long patient_id) {
		return service.getPatientById(patient_id);
	}

	@RequestMapping(value = "/api/insert/patient/new", method = RequestMethod.POST)
	public String addPatient(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestBody @Valid Patient patient) {
		return service.addPatient(patient);
	}

	@RequestMapping(value = "/api/update/patients", method = RequestMethod.PUT)
	public String updatePatientById(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestHeader Long patient_id) {
		return service.updatePatientById(patient_id);
	}

	@RequestMapping(value = "/api/delete/patients", method = RequestMethod.PUT)
	public String deletePatientById(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestHeader Long patient_id) {
		return service.deletePatientById(patient_id);
	}*/
}