package com.rokomari.beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "users")
@Data
@Accessors(chain = true)
@SequenceGenerator(name = "users_seq", initialValue = 1, allocationSize = 50)
public class JwtUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@JsonIgnore
	private Long id;

	@NotNull (message = "First name can not be empty")
	@Column(name = "first_name")
	private String first_name;

	@NotNull (message = "Last name can not be empty")
	@Column(name = "last_name")
	private String last_name;

	@Column(name = "email", length = 250)
	@NotNull (message = "email can not be empty")
	@Pattern(regexp = "^([^ @])+@([^ \\.@]+\\.)+([^ \\.@])+$")
	@Size(max = 250)
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(nullable = false)
	@ColumnDefault("'ROLE_USER'")
	@JsonIgnore
	private String role;

	@NotNull (message = "password can not be empty")
	@Column(name = "password", length = 250)
	private String password;

	@Transient
	private String status = "success";

	@Column(columnDefinition = "boolean default true")
	@JsonIgnore
	private boolean enabled;

	@Column(columnDefinition = "boolean default false")
	@JsonIgnore
	private boolean expired;

	@Column(columnDefinition = "boolean default false")
	@JsonIgnore
	private boolean locked;

	@PrePersist
	private void onSave() {
		role = "ROLE_USER";
		enabled = true;
	}

	@PreUpdate
	private void onupdate() {
		role = this.getRole();
		enabled = this.isEnabled();
		locked = this.isLocked();
		expired = this.isExpired();
	}
}
