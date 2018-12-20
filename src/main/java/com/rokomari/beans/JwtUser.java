package com.rokomari.beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "users")
@Data
@Accessors(chain = true)
public class JwtUser {

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

	@Column(name = "email", /*nullable = true,*/ length = 250)
	@NotNull
    @Pattern(regexp = "^([^ @])+@([^ \\.@]+\\.)+([^ \\.@])+$")
	@Size(max = 250)
	private String email;

	@Column(name = "mobile")
	private String mobile;
	
	private String role;
	@Column(name = "password", length = 250)
	@JsonIgnore
	private String password ;
	@Transient
	private String status = "success";
	
	@PrePersist
	private void onSave() {
		role = "ROLE_USER";
}
}
