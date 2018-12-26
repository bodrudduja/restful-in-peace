package com.rokomari.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8181101296155385878L;
	private String email;
	private String password;
	private String token;
	private String first_name;
	private String last_name;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtUserDetails(String email, String password, String first, String last, String token, List<GrantedAuthority> grantedAuthorities) {

		this.email = email;
		this.password = password;
		this.first_name = first;
		this.last_name = last;
		this.token = token;
		this.authorities = grantedAuthorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	private String getFirst_name() {
		return first_name;
	}

	private String getLast_name() {
		return last_name;
	}

	public String getEmail() {
		return email;
	}

	public String getToken() {
		return token;
	}
}
