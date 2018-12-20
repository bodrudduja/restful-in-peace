package com.rokomari.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class LoginSuccessResponse {
	String status;
	String first_name;
	String email;
	@JsonIgnore
	String password;
}
