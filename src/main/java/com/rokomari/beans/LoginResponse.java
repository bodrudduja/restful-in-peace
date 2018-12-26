package com.rokomari.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@NoArgsConstructor
public class LoginResponse 
{
	String status;
	String first_name;
	@NonNull
	String email;
	@JsonIgnore
	@NonNull
	String password;
}
