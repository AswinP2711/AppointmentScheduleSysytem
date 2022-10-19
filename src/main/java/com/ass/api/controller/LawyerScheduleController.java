package com.ass.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ass.api.dto.LawyerScheduleDto;
import com.ass.api.model.Lawyer;
import com.ass.api.model.LawyerSchedule;
import com.ass.api.repository.LawyerRepository;
import com.ass.api.repository.LawyerScheduleRepository;

@RestController
public class LawyerScheduleController {
	@Autowired
	private LawyerScheduleRepository  lawyerScheduleRepository;
	@Autowired
	private LawyerRepository lawyerRepository;
	@PostMapping("/lawyer/add/schedule")
	public LawyerSchedule addLawyerSchedule(@RequestBody LawyerScheduleDto lawyerScheduleDto){
		
		Optional<Lawyer> optionald=lawyerRepository.findById(lawyerScheduleDto.getLawyer_id());
		if (!optionald.isPresent()) {
			throw new RuntimeException();
		}
		Lawyer lawyer=optionald.get();
		LawyerSchedule lawyerSchedule=new LawyerSchedule();
		lawyerSchedule.setDate(lawyerScheduleDto.getDate());
		lawyerSchedule.setFrom_time(lawyerScheduleDto.getFrom_time());
		lawyerSchedule.setTo_time(lawyerScheduleDto.getTo_time());
		lawyerSchedule.setLawyer(lawyer);
		System.out.println(lawyerSchedule);
		return lawyerScheduleRepository.save(lawyerSchedule);
		
		
		
	}

}