package com.rokomari.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rokomari.beans.JwtUser;

@Repository
public interface UserRepository extends CrudRepository<JwtUser, Long> {

	JwtUser findJwtUserById(Long id);

	JwtUser findByEmail(String email);

	@Query("SELECT user FROM JwtUser user WHERE user.email=?1 and user.password=?2")
	JwtUser findByEmailAndPassword(String email, String password);

}
