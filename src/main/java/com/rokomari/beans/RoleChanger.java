package com.rokomari.beans;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RoleChanger {
	
	@NotNull (message = "User id can not be empty")
	Long id;
	
	@NotNull (message = "User's role can not be empty")
	String role;
}
