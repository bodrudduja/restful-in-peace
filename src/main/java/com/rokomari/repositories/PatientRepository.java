package com.rokomari.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rokomari.beans.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
	public List<Patient> findAll();

	public Patient findPatientById(Long id);

	public void deleteById(Long id);
}
