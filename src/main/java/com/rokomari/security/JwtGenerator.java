package com.rokomari.security;

import com.rokomari.beans.JwtUser;
import com.rokomari.repositories.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {


	@Autowired UserRepository repo;
    public String generate(JwtUser jwtUser) {

    	
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getEmail());
        claims.put("first_name", jwtUser.getFirst_name());
        claims.put("role",jwtUser.getRole());
        claims.put("last_name",jwtUser.getLast_name());
        


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "rokomari")
                .compact();
    }
}
