package com.rokomari.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rokomari.beans.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

	public List<Doctor> findAll();

	public Doctor findDoctorById(Long id);

	public void deleteById(Long id);
}
