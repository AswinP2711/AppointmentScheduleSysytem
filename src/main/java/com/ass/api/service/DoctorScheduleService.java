package com.ass.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ass.api.repository.DoctorScheduleRepository;

@Service
public class DoctorScheduleService {
	
	@Autowired
	private DoctorScheduleRepository doctorScheduleRepository;
}
