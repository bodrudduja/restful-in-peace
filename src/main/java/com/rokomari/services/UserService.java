package com.rokomari.services;

import com.rokomari.beans.JwtUser;
import com.rokomari.beans.LoginSuccessResponse;

public interface UserService {

	JwtUser addUser(JwtUser user);
	
	LoginSuccessResponse loginUser(String email, String password);
	
}
