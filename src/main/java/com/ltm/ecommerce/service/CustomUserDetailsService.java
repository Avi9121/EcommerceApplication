package com.ltm.ecommerce.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ltm.ecommerce.entity.User;
import com.ltm.ecommerce.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	public final UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username)  {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                    new RuntimeException("User not found"));
		 return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
	}

}
