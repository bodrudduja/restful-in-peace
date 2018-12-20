package com.rokomari.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "doctor")
@Data
@Accessors(chain = true)
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long doctorId;

	@NotNull(message = "Doctor's name can not be empty")
	private String name;

	@NotNull
	@Column(name = "dept")
	private String dept;

	@Column(name = "joining")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date joining;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "doctor_patient", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "patient_id"))
	List<Patient> patient = new ArrayList<>();

	@PrePersist
	private void onSave() {
	}

	@PreUpdate
	private void onUpdate() {
	}
}