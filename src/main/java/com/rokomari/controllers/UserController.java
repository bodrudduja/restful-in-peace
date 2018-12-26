package com.rokomari.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.rokomari.beans.RoleChanger;
import com.rokomari.beans.JwtUser;
import com.rokomari.beans.JwtUserDTO;
import com.rokomari.beans.JwtUserWithToken;
import com.rokomari.security.JwtGenerator;
import com.rokomari.services.UserService;
import com.rokomari.beans.LoginEntity;
import com.rokomari.beans.LoginResponse;
import com.rokomari.beans.Token;
import com.rokomari.exceptions.ResourceNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public JwtUserWithToken registerUser(@RequestHeader String token, @RequestBody @Valid JwtUser user) {
		
		JwtUser savedUser = service.addUser(token, user);
		JwtGenerator jwtgen = new JwtGenerator();
		JwtUserWithToken juwt = new JwtUserWithToken();
		juwt.setUser(savedUser);
		juwt.setJwt_token(jwtgen.generate(savedUser));

		return juwt;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponse loginUser(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestBody @Valid LoginEntity user) {
			System.out.println("In Controller"+user);
		LoginResponse l = service.loginUser(user.getEmail(), user.getPassword());
		if (l == null)
			throw new ResourceNotFoundException("Bad Credentials");
		return l;
	}

	@PreAuthorize("hasRole('SUPERADMIN')")
	@RequestMapping(value = "/superman/users/{id}", method = RequestMethod.GET)
	public JwtUserDTO getUserById(@RequestHeader String token, @RequestHeader String jwt_token, @PathVariable Long id) {
		return service.getUserById(id);
	}
	@PreAuthorize("hasRole('SUPERADMIN')")
	@RequestMapping(value = "/superman/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<JwtUserDTO> updateUserRole(@RequestHeader String token, @RequestHeader String jwt_token,
			@RequestBody @Valid RoleChanger user, @PathVariable Long id) {
		JwtUserDTO updatedUser = null;
		if (user != null) {
			updatedUser = service.changeUserRole(user);
		}
		return updatedUser == null ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED)
				: new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('SUPERADMIN')")
	@RequestMapping(value = "/superman/tokens", method = RequestMethod.GET)
	public List<Token> getApiKeys(@RequestHeader String token, @RequestHeader String jwt_token) {
		return service.getAllApiKeys();
	}

	@PreAuthorize("hasRole('SUPERADMIN')")
	@RequestMapping(value = "/superman/tokens/{id}", method = RequestMethod.GET)
	public Token getApiKeyById(@RequestHeader String token, @RequestHeader String jwt_token, @PathVariable Long id) {
		return service.getApiKeyById(id);
	}
}