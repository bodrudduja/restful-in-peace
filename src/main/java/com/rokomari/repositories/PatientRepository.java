package com.rokomari.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rokomari.beans.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

}
