package com.rokomari.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rokomari.beans.RoleChanger;
import com.rokomari.beans.JwtUser;
import com.rokomari.beans.JwtUserDTO;
import com.rokomari.beans.LoginResponse;
import com.rokomari.repositories.TokenRepository;
import com.rokomari.repositories.UserRepository;
import com.rokomari.beans.Token;
import com.rokomari.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;
	
	@Autowired TokenRepository tokenrepo;
	
	@Override
	public JwtUser addUser(String token, JwtUser user) {
		Token tokenfromRepo = tokenrepo.findByApikey(token);
		if(tokenfromRepo==null)
			return null;
		return repo.save(user);
	}

	@Override
	public LoginResponse loginUser(String email, String password) {
		System.out.println("email:"+email+ " password"+password);
		JwtUser ju = repo.findByEmailAndPassword(email, password);
		System.out.println("in service: "+ ju);
		if(ju==null) {
			return null;
		}
		LoginResponse lsr = new LoginResponse();
		lsr.setEmail(ju.getEmail());
		lsr.setFirst_name(ju.getFirst_name());
		lsr.setStatus("logged_in");
		return lsr;
	}

	@Override
	public JwtUserDTO changeUserRole(RoleChanger usr) {
		JwtUser user = repo.findJwtUserById(usr.getId());
		JwtUserDTO userDTO = null;
		if(user!=null) {
			user.setRole(usr.getRole());
			user = repo.save(user);
			System.out.println("In userService: "+user);
			userDTO= new JwtUserDTO();
			userDTO.setUser(user);
			userDTO.setId(user.getId());
			userDTO.setEnabled(user.isEnabled());
			userDTO.setExpired(user.isExpired());
			userDTO.setLocked(user.isLocked());
			userDTO.setRole(user.getRole());
			
		}
		return userDTO;
	}

	@Override
	public JwtUserDTO getUserById(Long id) {
		JwtUser user = repo.findJwtUserById(id);
		JwtUserDTO userDTO = null;
		if(user!=null) {
			userDTO= new JwtUserDTO();
			userDTO.setUser(user);
			userDTO.setId(user.getId());
			userDTO.setEnabled(user.isEnabled());
			userDTO.setExpired(user.isExpired());
			userDTO.setLocked(user.isLocked());
			userDTO.setRole(user.getRole());
			
		}
		return userDTO;
	}

	@Override
	public Token getApiKeyById(Long id) {
		return tokenrepo.findTokenById(id);
	}

	@Override
	public List<Token> getAllApiKeys() {
		return tokenrepo.findAll();
	}

}
