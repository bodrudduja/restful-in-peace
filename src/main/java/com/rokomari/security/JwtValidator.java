package com.rokomari.security;

import com.rokomari.beans.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

	private String secret = "rokomari";

	public JwtUser validate(String token) {
		JwtUser jwtUser = null;
		try {// body is payload portion of jwt token.. we are just decoding it from token
				// here
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			// A pojo to store the extracted payload as a object...
			jwtUser = new JwtUser();
			jwtUser.setEmail(body.getSubject());
			jwtUser.setFirst_name((String) body.get("first_name"));
			jwtUser.setPassword((String)body.get("password"));
			jwtUser.setLast_name((String) body.get("last_name"));
		} catch (Exception e) {
			System.out.println(e);
		}

		return jwtUser;
	}
}
