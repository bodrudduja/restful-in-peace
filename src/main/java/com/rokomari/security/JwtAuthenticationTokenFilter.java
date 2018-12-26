package com.rokomari.security;

import com.rokomari.beans.Token;
import com.rokomari.repositories.TokenRepository;
import com.rokomari.security.JwtAuthenticationToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	@Autowired
	TokenRepository repo;

	public JwtAuthenticationTokenFilter() {
		super(new OrRequestMatcher(new AntPathRequestMatcher("/login"),
				new AntPathRequestMatcher("/api/**"), new AntPathRequestMatcher("/superman/**")));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

		String token_header = httpServletRequest.getHeader("token");
		String jwt_token_header = httpServletRequest.getHeader("jwt_token");
		Token storedToken = repo.findByApikey(token_header);
		//System.out.println("stored token:"+storedToken+" tokenheader:"+token_header);
		if (storedToken.getApikey().isEmpty() || !storedToken.isEnabled() || !storedToken.getApikey().equals(token_header)) {
			//System.out.println("-->"+storedToken.getApikey().isEmpty()+"-->"+storedToken.isEnabled());
			throw new RuntimeException("token is missing or incorrect");
		}

		if (jwt_token_header == null) {
			throw new RuntimeException("jwt_token is missing");
		}

		String authenticationToken = jwt_token_header;

		JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
		return getAuthenticationManager().authenticate(token);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}
}
