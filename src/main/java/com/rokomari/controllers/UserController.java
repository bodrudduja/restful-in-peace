package com.rokomari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rokomari.beans.JwtUser;
import com.rokomari.beans.JwtUserWithToken;
import com.rokomari.security.JwtGenerator;
import com.rokomari.services.UserService;
import com.rokomari.beans.LoginSuccessResponse;
import com.rokomari.beans.Status;
import com.rokomari.exceptions.ResourceNotFoundException;
@RestController
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public JwtUserWithToken registerUser(@RequestHeader String token, @RequestBody JwtUser user) 
	{
		JwtUser savedUser = service.addUser(user);
		JwtGenerator jwtgen = new JwtGenerator();
	    JwtUserWithToken juwt = new JwtUserWithToken();
	    juwt.setUser(savedUser);
	    juwt.setJwt_token(jwtgen.generate(savedUser));
	    
	    return juwt;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginSuccessResponse loginUser(@RequestHeader String token,
			@RequestBody LoginSuccessResponse user) {
		LoginSuccessResponse l = service.loginUser(user.getEmail(), user.getPassword());
		if(l==null)
			throw new ResourceNotFoundException("Bad Credentials");
		return l;
	}
}