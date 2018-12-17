package com.rokomari.beans;

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
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@NotNull(message = "Patient's name can not be empty")
	private String name;

	@NotNull
	@Column(name = "mobile", length = 15)
	private String mobile;

	@Column(name = "age", length = 3)
	private Long age;

	@NotNull
	@Column(name = "gender")
	private Gender gender;

	@Column(name = "occupation", length = 50)
	private String occupation;

	@Column(name = "symptom_summery", length = 1000)
	private String symptom_summery;

	@PrePersist
	private void onSave() {

	}

	@PreUpdate
	private void onUpdate() {
	}
}