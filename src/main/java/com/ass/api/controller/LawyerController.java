package com.ass.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ass.api.model.Doctor;
import com.ass.api.model.Lawyer;
import com.ass.api.model.User;
import com.ass.api.repository.LawyerRepository;
import com.ass.api.repository.UserRepository;
import com.ass.api.service.LawyerService;

@RestController
public class LawyerController {
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private LawyerService lawyerservice;
	 
	@Autowired
	private LawyerRepository lawyerRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	@PostMapping("/lawyer/add")
	public void insertUser(@RequestBody Lawyer lawyer) {
		User user=lawyer.getUser();
		if (user==null) {
			throw new RuntimeException("User data not present");
		}
		user.setRole("LAWYER");
		String encryptedPassword=encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword); 
		
		user=userRepository.save(user);
		
		lawyer.setUser(user);
		lawyer.setStatus("Not Verified");
		
		lawyerRepository.save(lawyer);
	}

	

	@GetMapping("/lawyer/all")
	public List<Lawyer> getAllLawyer() {
		List<Lawyer> list = lawyerservice.getAllLawyer();
		return list;
	}
	
	@GetMapping("/lawyer/notverified/all")
	public Lawyer getNotVerifiedLawyer(){
		String con="Not Verified";
		return lawyerRepository.getNotVerifiedDoctor(con);
	}
	
	@PutMapping("/lawyer/verify/{did}")
	public Lawyer acceptLawyer(@PathVariable("did") Long did) {
		Optional<Lawyer> optionalD=lawyerRepository.findById(did);
		if (!optionalD.isPresent()) {
			throw new RuntimeException();
		}
		Lawyer lawyer=optionalD.get();
		Lawyer lawyerNew=new Lawyer();
		lawyerNew.setId(lawyer.getId());;
		lawyerNew.setName(lawyer.getName());
		lawyerNew.setAddress(lawyer.getAddress());
		lawyerNew.setContact(lawyer.getContact());
		lawyerNew.setSpecialisation(lawyer.getSpecialisation());
		lawyerNew.setStatus("Verified");
		lawyerNew.setUser(lawyer.getUser());
		return lawyerRepository.save(lawyerNew);
		
	}
	
	@PutMapping("/lawyer/reject/{did}")
	public Lawyer rejectDoctor(@PathVariable("did") Long did) {
		Optional<Lawyer> optionalD=lawyerRepository.findById(did);
		if (!optionalD.isPresent()) {
			throw new RuntimeException();
		}
		Lawyer lawyer=optionalD.get();
		Lawyer lawyerNew=new Lawyer();
		lawyerNew.setId(lawyer.getId());;
		lawyerNew.setName(lawyer.getName());
		lawyerNew.setAddress(lawyer.getAddress());
		lawyerNew.setContact(lawyer.getContact());
		lawyerNew.setSpecialisation(lawyer.getSpecialisation());
		lawyerNew.setStatus("Rejected");
		lawyerNew.setUser(lawyer.getUser());
		return lawyerRepository.save(lawyerNew);
		
	}

	@DeleteMapping("/lawyer/delete")
	public void deleteByIdV2(@RequestParam("id") Long id) {
		lawyerservice.deleteById(id);
	}
}
