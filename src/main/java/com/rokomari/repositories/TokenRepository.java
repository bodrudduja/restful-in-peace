package com.rokomari.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rokomari.beans.Token;

public interface TokenRepository extends CrudRepository<Token, Long> {

	Token findTokenById(Long id);

	public List<Token> findAll();

	Token findByApikey(String token_header);

}
