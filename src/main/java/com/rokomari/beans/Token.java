package com.rokomari.beans;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "token")
@Data
@SequenceGenerator(name = "token_seq", initialValue = 1, allocationSize = 50)
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_seq")
	Long id;

	@Column(unique = true, nullable = false)
	String apikey;

	@Column(unique = true, nullable = false, columnDefinition = "boolean default true")
	boolean enabled;

	@PrePersist
	private void onSave() {
		//this.apikey = UUID.randomUUID().toString();
	}

	@PreUpdate
	private void onUpdate() {
		this.apikey = UUID.randomUUID().toString();
	}
}