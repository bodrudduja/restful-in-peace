package com.rokomari.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rokomari.beans.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
