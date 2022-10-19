package com.ass.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ass.api.model.Doctor;
import com.ass.api.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor insertDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public List<Doctor> getAllDoctor() {
		return doctorRepository.findAll();
	}

	public void deleteById(Long id) {
		doctorRepository.deleteById(id);
	}
	
	
}
