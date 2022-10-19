package com.ass.api.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ass.api.dto.DoctorAppointmentDto;
import com.ass.api.model.Customer;
import com.ass.api.model.DoctorAppointment;
import com.ass.api.model.DoctorSchedule;
import com.ass.api.repository.CustomerRepository;
import com.ass.api.repository.DoctorAppointmentRepository;
import com.ass.api.repository.DoctorScheduleRepository;

@RestController
public class DoctorAppointmentController {
	@Autowired
	DoctorAppointmentRepository doctorAppointmentRepository;
	
	@Autowired
	private DoctorScheduleRepository doctorScheduleRepository;
	
	@Autowired 
	private CustomerRepository CustomerRepository;
	
	@PostMapping("/doctor/appointment/add")
	public DoctorAppointment addDoctorAppointment(@RequestBody DoctorAppointmentDto doctorAppointmentDto) {
		Optional<Customer> optionalC=CustomerRepository.findById(doctorAppointmentDto.getCustomer_id());
		if (!optionalC.isPresent()) {
			throw new RuntimeException();
		}
		Customer customer=optionalC.get();
		
		
		Optional<DoctorSchedule> optionalD=doctorScheduleRepository.findById(doctorAppointmentDto.getDoctorSchedule_id());
		if (!optionalD.isPresent()) {
			throw new RuntimeException();
		}
		DoctorSchedule doctorSchedule=optionalD.get();
		
		DoctorAppointment doctorAppointment=new DoctorAppointment();
		doctorAppointment.setCustomer(customer);
		doctorAppointment.setDoctorSchedule(doctorSchedule);
		doctorAppointment.setStatus("Not Verified");
		System.out.println(doctorAppointment);
		return doctorAppointmentRepository.save(doctorAppointment);
	}
	
	@GetMapping("/doctor/appointment/view/all")
	public List<DoctorAppointment> getAllDoctorAppointment() {
		System.out.println(doctorAppointmentRepository.findAll());
		return doctorAppointmentRepository.findAll();
	}
	
	@GetMapping("/doctor/appointment/view/{did}")
	public List<DoctorAppointment> getDoctorAppointmentByDoctorId(@PathVariable("did") Long did) {
		return doctorAppointmentRepository.getDoctorAppointmentByDoctorId(did);
	}
	
	@GetMapping("/doctor/user/appointment/view/{uid}")
	public List<DoctorAppointment> getDoctorAppointmentByCustomerId(@PathVariable("uid") Long did) {
		return doctorAppointmentRepository.getDoctorAppointmentByCustomerId(did);
	}
	
	@PutMapping("/doctor/accept/appointment/{aid}")
	public DoctorAppointment acceptDoctorAppointment(@PathVariable("aid") Long aid) {
		Optional<DoctorAppointment> optionalD=doctorAppointmentRepository.findById(aid);
		if (!optionalD.isPresent()) {
			throw new RuntimeException();
		}
		DoctorAppointment doctorAppointment=optionalD.get();
		DoctorAppointment doctorAppointmentNew=new DoctorAppointment();
		doctorAppointmentNew.setId(doctorAppointment.getId());
		doctorAppointmentNew.setCustomer(doctorAppointment.getCustomer());
		doctorAppointmentNew.setDoctorSchedule(doctorAppointment.getDoctorSchedule());
		doctorAppointmentNew.setStatus("Accepted");
		return doctorAppointmentRepository.save(doctorAppointmentNew);
		
	}
	@PutMapping("/doctor/reject/appointment/{aid}")
	public DoctorAppointment rejectDoctorAppointment(@PathVariable("aid") Long aid) {
		Optional<DoctorAppointment> optionalD=doctorAppointmentRepository.findById(aid);
		if (!optionalD.isPresent()) {
			throw new RuntimeException();
		}
		DoctorAppointment doctorAppointment=optionalD.get();
		DoctorAppointment doctorAppointmentNew=new DoctorAppointment();
		doctorAppointmentNew.setId(doctorAppointment.getId());
		doctorAppointmentNew.setCustomer(doctorAppointment.getCustomer());
		doctorAppointmentNew.setDoctorSchedule(doctorAppointment.getDoctorSchedule());
		doctorAppointmentNew.setStatus("Rejected");
		return doctorAppointmentRepository.save(doctorAppointmentNew);
		
	}
}
