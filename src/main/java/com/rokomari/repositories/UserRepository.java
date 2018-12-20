package com.rokomari.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rokomari.beans.JwtUser;

@Repository
public interface UserRepository extends CrudRepository<JwtUser, Long> {
	JwtUser findByEmail(String email);
	JwtUser findByEmailAndPassword(String email, String password);
}
