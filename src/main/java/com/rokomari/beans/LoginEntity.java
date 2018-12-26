package com.rokomari.beans;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class LoginEntity {
	@NotNull (message = "User's email can not be empty")
	@NonNull
	String email;
	@NonNull
	@NotNull(message = "User's password can not be empty")
	String password;
}
