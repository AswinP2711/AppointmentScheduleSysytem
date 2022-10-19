package com.ass.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ass.api.model.Customer;
import com.ass.api.repository.CustomerRepository;
@Service
public class CustomerService {
	@Autowired
	private CustomerRepository userRepository;

	public Customer insertUser(Customer user) {
		
		return userRepository.save(user);
	}

	public List<Customer> getAllUsers() {
		
		return userRepository.findAll();
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
		
	}

}
