package com.rokomari.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rokomari.Gender;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "patient")
@Data
@Accessors(chain = true)
@SequenceGenerator(name = "patient_seq", initialValue = 1, allocationSize = 50)
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
	@JsonIgnore
	private Long patientId;

	@NotNull(message = "Patient's name can not be empty")
	private String name;
	
	@Column(name = "mobile", length = 15)
	private String mobile;
	
	@NotNull (message = "Patient's age can not be empty")
	@Column(name = "age", length = 3)
	private Long age;

	@NotNull (message = "Patient's gender can not be empty")
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "occupation", length = 50)
	private String occupation;

	@Column(name = "symptom_summery", length = 1000)
	private String symptom_summery;
	
	@ManyToMany(mappedBy="patient")
	List<Doctor> doctor = new ArrayList<>();
	
	@PrePersist
	private void onSave() {

	}

	@PreUpdate
	private void onUpdate() {
	}
}