package com.rokomari.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.rokomari.beans.Patient;
import com.rokomari.beans.Status;
import com.rokomari.services.PatientService;

import ch.qos.logback.classic.Logger;

@RestController
public class PatientController {

	public static final Logger logger = (Logger) LoggerFactory.getLogger(PatientController.class);
	@Autowired
	private PatientService service;

	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN') OR hasRole('SUPERADMIN')")
	@RequestMapping(value = "/api/patients", method = RequestMethod.GET)
	public List<Patient> getAllPatients(@RequestHeader String token, @RequestHeader String jwt_token) {
		return service.getAllPatients();
	}

	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN') OR hasRole('SUPERADMIN')")
	@RequestMapping(value = "/api/patients", method = RequestMethod.GET, headers = "patient_id")
	public Patient getPatientById(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestHeader Long patient_id) {
		return service.getPatientById(patient_id);
	}

	@PreAuthorize("hasRole('ADMIN') OR hasRole('SUPERADMIN')")
	@RequestMapping(value = "/api/insert/patient/new", method = RequestMethod.POST)
	public ResponseEntity<Status> addPatient(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestBody @Valid Patient patient) {
		Patient d = null;
		d = service.addPatient(patient);
		if (d != null)
			return new ResponseEntity<>(new Status("success"), HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@PreAuthorize("hasRole('ADMIN') OR hasRole('SUPERADMIN')")
	@RequestMapping(value = "/api/update/patients", method = RequestMethod.PUT)
	public ResponseEntity<Status> updatePatientById(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestHeader Long patient_id, @RequestBody @Valid Patient patient) {
		Patient d = null;
		d = service.updatePatientById(patient_id, patient);
		if (d != null)
			return new ResponseEntity<>(new Status("updated"), HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PreAuthorize("hasRole('ADMIN') OR hasRole('SUPERADMIN')")
	@RequestMapping(value = "/api/delete/patients", method = RequestMethod.DELETE)
	public ResponseEntity<Status> deletePatientById(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestHeader Long patient_id) {
		service.deletePatientById(patient_id);
		return new ResponseEntity<>(new Status("deleted"), HttpStatus.OK);
	}
}