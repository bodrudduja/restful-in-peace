package com.rokomari.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rokomari.beans.Patient;
import com.rokomari.repositories.PatientRepository;
import com.rokomari.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository repo;
	
	@Override
	public List<Patient> getAllPatients() {
		return repo.findAll();
	}

	@Override
	public Patient getPatientById(long patient_id) {
		return repo.findPatientByPatientId(patient_id);
	}

	@Override
	public Patient addPatient(Patient patient) {
		return repo.save(patient);
	}

	@Override
	public Patient updatePatientById(Long patient_id,Patient patient) {
		Patient p = repo.findPatientByPatientId(patient_id);
		if (p == null) {
			return p;
		}
		else {
			patient.setPatientId(patient_id);
		}	return repo.save(patient);
	}

	@Override
	public void deletePatientById(Long patient_id) {
		repo.deleteById(patient_id);
	}

}
