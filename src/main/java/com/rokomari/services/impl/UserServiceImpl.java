package com.rokomari.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rokomari.beans.JwtUser;
import com.rokomari.beans.LoginSuccessResponse;
import com.rokomari.repositories.UserRepository;
import com.rokomari.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;

	@Override
	public JwtUser addUser(JwtUser user) {
		
		return repo.save(user);
	}

	@Override
	public LoginSuccessResponse loginUser(String email, String password) {
		JwtUser ju = repo.findByEmailAndPassword(email, password);
		if(ju==null) {
			return null;
		}
		LoginSuccessResponse lsr = new LoginSuccessResponse();
		lsr.setEmail(ju.getEmail());
		lsr.setFirst_name(ju.getFirst_name());
		lsr.setStatus("logged_in");
		return lsr;
	}

}
