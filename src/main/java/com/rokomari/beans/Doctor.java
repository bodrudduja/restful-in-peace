package com.rokomari.beans;

import java.util.Date;

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
	private Long id;

	@NotNull(message = "Doctor's name can not be empty")
	private String name;

	@NotNull
	@Column(name = "dept")
	private String dept;

	@Column(name = "joining")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date joining;

	@PrePersist
	private void onSave() {
	}

	@PreUpdate
	private void onUpdate() {
	}
}