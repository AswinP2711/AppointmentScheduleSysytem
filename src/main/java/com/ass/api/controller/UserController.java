package com.ass.api.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ass.api.dto.CustomerDto;
import com.ass.api.dto.DoctorDto;
import com.ass.api.dto.LawyerDto;
import com.ass.api.model.Customer;
import com.ass.api.model.Doctor;
import com.ass.api.model.Lawyer;
import com.ass.api.model.User;
import com.ass.api.repository.CustomerRepository;
import com.ass.api.repository.DoctorRepository;
import com.ass.api.repository.LawyerRepository;
import com.ass.api.repository.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired 
	private DoctorRepository doctorRepository;
	
	@Autowired 
	private LawyerRepository lawyerRepository;
	
	
	
	@GetMapping("/user/login")
	public User userLogin(Principal principal) {
		String username=principal.getName();
		User user = userRepository.findByUsername(username);
		return user;
	}
	
	@GetMapping("/user/details")
	public Object getUserDetails(Principal principal) {
		String username=principal.getName();
		User user = userRepository.findByUsername(username);
		
		if (user.getRole().equalsIgnoreCase("CUSTOMER")) {
			Customer customer= customerRepository.getCustomerDetails(username);
			CustomerDto dto = new CustomerDto(customer.getId(), customer.getName(), customer.getDate_of_birth(), customer.getPhone_no(), customer.getCity());
			return dto;
		}
		if (user.getRole().equalsIgnoreCase("DOCTOR")) {
			Doctor doctor= doctorRepository.getDoctorDetails(username);
			DoctorDto dto = new DoctorDto(doctor.getId(), doctor.getName(), doctor.getAddress(), doctor.getContact(), doctor.getSpecialisation(),doctor.getStatus());
			return dto;
		}
		if (user.getRole().equalsIgnoreCase("LAWYER")) {
			Lawyer lawyer= lawyerRepository.getLawyerDetails(username);
			LawyerDto dto = new LawyerDto(lawyer.getId(), lawyer.getName(), lawyer.getAddress(), lawyer.getContact(), lawyer.getSpecialisation(),lawyer.getStatus());
			return dto;
		}
		return null;
		
	}
}
