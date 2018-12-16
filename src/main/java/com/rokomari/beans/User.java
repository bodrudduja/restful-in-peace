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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@NotNull
	@Column(name = "first_name")
	private String first_name;

	@NotNull
	@Column(name = "last_name")
	private String last_name;

	@NotNull
	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@NotNull
	@Column(name = "password")
	private String password;

	@PrePersist
	private void onSave() {

	}

	@PreUpdate
	private void onUpdate() {
	}
}