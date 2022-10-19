package com.ass.api.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ass.api.dto.DoctorScheduleDto;
import com.ass.api.model.Doctor;
import com.ass.api.model.DoctorSchedule;
import com.ass.api.repository.DoctorRepository;
import com.ass.api.repository.DoctorScheduleRepository;

@RestController
public class DoctorScheduleController {
	
	
	@Autowired
	private DoctorScheduleRepository  doctorScheduleRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@PostMapping("/doctor/add/schedule")
	public DoctorSchedule addDoctorSchedule(@RequestBody DoctorScheduleDto doctorScheduleDto) {
		
		Optional<Doctor> optionald=doctorRepository.findById(doctorScheduleDto.getDoctor_id());
		if (!optionald.isPresent()) {
			throw new RuntimeException();
		}
		Doctor doctor=optionald.get();
		DoctorSchedule doctorSchedule=new DoctorSchedule();
		doctorSchedule.setDate(doctorScheduleDto.getDate());
		doctorSchedule.setFrom_time(doctorScheduleDto.getFrom_time());
		doctorSchedule.setTo_time(doctorScheduleDto.getTo_time());
		doctorSchedule.setDoctor(doctor);
		return doctorScheduleRepository.save(doctorSchedule);
		
		
		
	}

}
