package com.rokomari.services;

import com.rokomari.beans.User;

public interface UserService {

	User addUser(User user);

	User loginUser();
}
