package com.rokomari.beans;

import lombok.Data;

@Data
public class JwtUserWithToken {

	JwtUser user;
	String jwt_token;

}
