package com.rokomari.security;

import com.rokomari.beans.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

	private String secret = "rokomari";

	public String generate(JwtUser jwtUser) {

		Claims claims = Jwts.claims().setSubject(jwtUser.getEmail());
		claims.put("password", jwtUser.getPassword());
		claims.put("first_name", jwtUser.getFirst_name());
		claims.put("last_name", jwtUser.getLast_name());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
