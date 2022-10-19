package com.ass.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ass.api.model.Customer;
import com.ass.api.model.User;
import com.ass.api.repository.CustomerRepository;
import com.ass.api.repository.UserRepository;
import com.ass.api.service.CustomerService;


@RestController
public class CustomerController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerService userService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/customer/add")
	public void insertUser(@RequestBody Customer customer) {
		User user=customer.getUser();
		if (user==null) {
			throw new RuntimeException("User data not present");
		}
		user.setRole("CUSTOMER");
		String encryptedPassword=encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword); 
		
		user=userRepository.save(user);
		
		customer.setUser(user);
		
		customerRepository.save(customer);
	}
	
	@GetMapping("/customer/all")
	public List<Customer> getAllUsers() {
		List<Customer> list=userService.getAllUsers();
		return list;
	}
	@DeleteMapping("/customer/delete")
	public void deleteById(@RequestParam("id") Long id) {
		userService.deleteById(id);
	}

}
