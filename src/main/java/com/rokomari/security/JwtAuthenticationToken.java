package com.rokomari.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7530091947451820522L;
	private String jwt_token;

	public JwtAuthenticationToken(String token) {
		super(null, null);
		this.jwt_token = token;
	}

	public String getToken() {
		return jwt_token;
	}

	public void setToken(String token) {
		this.jwt_token = token;
	}

	@JsonIgnore
	@Override
	public Object getCredentials() {
		return null;
	}

	@JsonIgnore
	@Override
	public Object getPrincipal() {
		return null;
	}
}
