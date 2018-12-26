package com.rokomari.security;

import com.rokomari.security.JwtAuthenticationToken;
import com.rokomari.beans.JwtUser;
import com.rokomari.repositories.UserRepository;
import com.rokomari.security.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtValidator validator;

	@Autowired
	UserRepository repo;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

	}

	@Override // input tokn is being passed for validation
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
		// converting to our jwttokentype
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
		// extracting it as a string
		String token = jwtAuthenticationToken.getToken();
		// Extract payload(user information) from token by jwt decoder if data is
		// correct. return payload as JwtUser POJO.
		JwtUser jwtUser = validator.validate(token);
		// If token is invalid JwtUser will be null
		if (jwtUser == null) {
			throw new RuntimeException("JWT Token is incorrect");
		}
		// Will will return a UserDetails, So we need to pass a list of authorities of
		// user.we can load it from db or where it is stored
		// AuthorityUtils converts a comma separated authorities to List of authority of
		// type GrantedAuthority.Here roles will be loaded from jwtUser
		JwtUser userFromRepo = repo.findByEmailAndPassword(jwtUser.getEmail(),jwtUser.getPassword());
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(userFromRepo.getRole());
		// We are passing token too in The JwtUserDetails which implements UserDetails.

		return new JwtUserDetails(jwtUser.getEmail(), jwtUser.getPassword(),jwtUser.getFirst_name(), jwtUser.getLast_name(), token, grantedAuthorities);
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
	}
}
