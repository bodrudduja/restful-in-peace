package com.rokomari.services;

import java.util.List;

import com.rokomari.beans.RoleChanger;
import com.rokomari.beans.JwtUser;
import com.rokomari.beans.JwtUserDTO;
import com.rokomari.beans.LoginResponse;
import com.rokomari.beans.Token;

public interface UserService {

	JwtUser addUser(String token, JwtUser user);

	LoginResponse loginUser(String email, String password);

	JwtUserDTO getUserById(Long id);

	JwtUserDTO changeUserRole(RoleChanger usr);

	Token getApiKeyById(Long id);

	List<Token> getAllApiKeys();

}
