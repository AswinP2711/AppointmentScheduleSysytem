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
import com.ass.api.model.User;
import com.ass.api.repository.DoctorRepository;
import com.ass.api.repository.UserRepository;
import com.ass.api.service.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/doctor/add")
	public void insertUser(@RequestBody Doctor doctor) {
		User user=doctor.getUser();
		if (user==null) {
			throw new RuntimeException("User data not present");
		}
		user.setRole("DOCTOR");
		String encryptedPassword=encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword); 
		
		user=userRepository.save(user);
		
		doctor.setUser(user);
		doctor.setStatus("Not Verified");
		
		doctorRepository.save(doctor);
	}
	
	@GetMapping("/doctor/all")
	public List<Doctor> getAllDoctor(){
		List<Doctor> list = doctorService.getAllDoctor();
		return list;
	}
	
	@GetMapping("/doctor/notverified/all")
	public Doctor getNotVerifiedDoctor(){
		String con="Not Verified";
		return doctorRepository.getNotVerifiedDoctor(con);
	}
	
	@PutMapping("/doctor/verify/{did}")
	public Doctor acceptDoctor(@PathVariable("did") Long did) {
		Optional<Doctor> optionalD=doctorRepository.findById(did);
		if (!optionalD.isPresent()) {
			throw new RuntimeException();
		}
		Doctor doctor=optionalD.get();
		Doctor doctorNew=new Doctor();
		doctorNew.setId(doctor.getId());
		doctorNew.setName(doctor.getName());
		doctorNew.setAddress(doctor.getAddress());
		doctorNew.setContact(doctor.getContact());
		doctorNew.setSpecialisation(doctor.getSpecialisation());
		doctorNew.setStatus("Verified");
		doctorNew.setUser(doctor.getUser());
		return doctorRepository.save(doctorNew);
		
	}
	
	@PutMapping("/doctor/reject/{did}")
	public Doctor rejectDoctor(@PathVariable("did") Long did) {
		Optional<Doctor> optionalD=doctorRepository.findById(did);
		if (!optionalD.isPresent()) {
			throw new RuntimeException();
		}
		Doctor doctor=optionalD.get();
		Doctor doctorNew=new Doctor();
		doctorNew.setId(doctor.getId());
		doctorNew.setName(doctor.getName());
		doctorNew.setAddress(doctor.getAddress());
		doctorNew.setContact(doctor.getContact());
		doctorNew.setSpecialisation(doctor.getSpecialisation());
		doctorNew.setStatus("Rejected");
		doctorNew.setUser(doctor.getUser());
		return doctorRepository.save(doctorNew);
		
	}
	
	@DeleteMapping("/doctor/delete")
	public void deleteByIdV2(@RequestParam("id") Long id) {
		doctorService.deleteById(id);
	}

}
