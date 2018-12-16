package com.rokomari.services;

import java.util.List;

import com.rokomari.beans.Doctor;

public interface DoctorService {

	List<Doctor> getAllDoctors();

	Doctor getDoctorById(Long doctor_id);

	Doctor addDoctor(Doctor doctor);

	Doctor updateDoctorById(Long doctor_id, Doctor doctor);

	String deleteDoctorById(Long patient_id);
}
