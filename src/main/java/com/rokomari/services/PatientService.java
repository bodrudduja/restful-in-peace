package com.rokomari.services;

import java.util.List;

import com.rokomari.beans.Patient;

public interface PatientService {

	List<Patient> getAllPatients();

	Patient getPatientById(long patient_id);

	Patient addPatient(Patient patient);

	Patient updatePatientById(Long patient_id,Patient patient);

	void deletePatientById(Long patient_id);
}
