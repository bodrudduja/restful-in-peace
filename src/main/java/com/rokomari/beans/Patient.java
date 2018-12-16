package com.rokomari.beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@NotNull(message = "Client's name can not be empty")
	private String name;

	@NotNull
	@Column(name = "mobile")
	private String mobile;

	@Column(name = "age")
	private Long age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "symptom_summery")
	private String symptom_summery;

	@PrePersist
	private void onSave() {

	}

	@PreUpdate
	private void onUpdate() {
	}
}