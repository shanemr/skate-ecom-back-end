package com.infy.config;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.infy.entity.UserEntity;
import com.infy.repository.UserRepository;
import com.infy.config.JwtUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter{
	
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private  JwtUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String authHeader = request.getHeader("Authorization");
		System.out.println("AUTH is "+ authHeader);
		final String userEmail;
		final String jwtToken;
		
		
		if(authHeader == null || !authHeader.startsWith("Bearer")) {
			System.out.println("In IF");
			filterChain.doFilter(request, response);
			return;
		}
		// Get token from bearer part of header
		jwtToken = authHeader.substring(7);
		// Use token to validate email and get email
		userEmail = jwtUtils.extractUsername(jwtToken);
		System.out.println("User email " + userEmail);
		
		if(userEmail !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserEntity userEntity =  userRepository.findByEmail(userEmail);
			UserDetails userDetails = new User(
					userEntity.getEmail(),
					userEntity.getPassword(),
					Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
					);
			System.out.println("User Details " + userDetails);
			
			if(jwtUtils.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}

	
	}