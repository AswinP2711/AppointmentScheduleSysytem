package com.ass.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ass.api.model.Lawyer;
import com.ass.api.repository.LawyerRepository;

@Service
public class LawyerService {
	@Autowired
	private LawyerRepository lawyerRepository;

	public Lawyer insertLawyer(Lawyer lawyer) {
		return lawyerRepository.save(lawyer);
	}

	public List<Lawyer> getAllLawyer() {
		return lawyerRepository.findAll();	
	}

	public void deleteById(Long id) {
		lawyerRepository.deleteById(id);
		
	}

		
	
}
