package com.ass.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ass.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
}
