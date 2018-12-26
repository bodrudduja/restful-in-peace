package com.rokomari.beans;

import lombok.Data;

@Data
public class JwtUserDTO {
	
	JwtUser user;
	Long id;
	boolean enabled;
	boolean locked;
	boolean expired;
	String role;
}
