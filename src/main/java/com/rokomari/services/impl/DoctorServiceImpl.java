package com.rokomari.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rokomari.beans.Doctor;
import com.rokomari.repositories.DoctorRepository;
import com.rokomari.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository repo;

	@Override
	public Doctor getDoctorById(Long doctor_id) {
		return repo.findDoctorById(doctor_id);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return repo.findAll();
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return repo.save(doctor);
	}

	@Override
	public String deleteDoctorById(Long patient_id) {
		// TODO Auto-generated method stub
		return "Didn't implemented";
	}

	@Override
	public Doctor updateDoctorById(Long doctor_id, Doctor doctor) {
		// TODO Auto-generated method stub
		Doctor d = repo.findDoctorById(doctor_id);
		if (d == null) {
			return d;
		} else
			return repo.save(doctor);
	}

}