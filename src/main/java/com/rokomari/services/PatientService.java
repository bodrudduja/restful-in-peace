package com.rokomari.services;

import java.util.List;

import com.rokomari.beans.Patient;

public interface PatientService {

	List<Patient> getAllPatients();

	Patient getPatientById(long patient_id);

	String addPatient(Patient patient);

	String updatePatientById(Long patient_id);

	String deletePatientById(Long patient_id);
}
