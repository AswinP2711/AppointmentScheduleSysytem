package com.ass.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ass.api.model.User;
import com.ass.api.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException("Invalid Credentials");
		}
		
		return new org.springframework.security.core.userdetails.User
				(user.getUsername(), user.getPassword(), user.getAuthorities());
	}
	
		
}
