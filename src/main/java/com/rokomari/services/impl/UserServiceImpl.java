package com.rokomari.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rokomari.beans.User;
import com.rokomari.repositories.UserRepository;
import com.rokomari.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;

	@Override
	public User addUser(User user) {
		return repo.save(user);
	}

	@Override
	public User loginUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
