package com.rokomari.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.rokomari.beans.Doctor;
import com.rokomari.beans.Status;
import com.rokomari.services.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService service;
	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN') OR hasRole('SUPERADMIN')")
	@RequestMapping(value = "/api/doctors", method = RequestMethod.GET)
	public List<Doctor> getAllDoctors(@RequestHeader String token, @RequestHeader String jwt_token) {
		return service.getAllDoctors();
	}

	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN') OR hasRole('SUPERADMIN')")
	@RequestMapping(value = "/api/doctors", method = RequestMethod.GET, headers = "doctor_id")
	public Doctor getDoctorById(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestHeader Long doctor_id) {
		return service.getDoctorById(doctor_id);
	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('SUPERADMIN')")
	@RequestMapping(value = "/api/insert/doctor/new", method = RequestMethod.POST)
	public ResponseEntity<Status> addDoctor(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestBody @Valid Doctor doctor) {
		Doctor d = null;
		d = service.addDoctor(doctor);
		if (d != null)
			return new ResponseEntity<>(new Status("success"), HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
	@PreAuthorize("hasRole('ADMIN') OR hasRole('SUPERADMIN')")
	@RequestMapping(value = "/api/update/doctors", method = RequestMethod.PUT)
	public ResponseEntity<Status> updateDoctorById(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestHeader Long doctor_id, @RequestBody @Valid Doctor doctor) {
		Doctor d = null;
		d = service.updateDoctorById(doctor_id, doctor);
		if (d != null)
			return new ResponseEntity<>(new Status("updated"), HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PreAuthorize("hasRole('ADMIN') OR hasRole('SUPERADMIN')")
	@RequestMapping(value = "/api/delete/doctors", method = RequestMethod.DELETE)
	public ResponseEntity<Status> deleteDoctorById(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestHeader Long doctor_id) {
		service.deleteDoctorById(doctor_id);
		return new ResponseEntity<>(new Status("deleted"), HttpStatus.OK);
	}
}