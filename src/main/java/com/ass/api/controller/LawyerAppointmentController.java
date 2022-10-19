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

import com.ass.api.dto.LawyerAppointmentDto;
import com.ass.api.model.Customer;
import com.ass.api.model.DoctorAppointment;
import com.ass.api.model.LawyerAppointment;
import com.ass.api.model.LawyerSchedule;
import com.ass.api.repository.CustomerRepository;
import com.ass.api.repository.LawyerAppointmentRepository;
import com.ass.api.repository.LawyerScheduleRepository;

@RestController
public class LawyerAppointmentController {
	
	@Autowired
	private LawyerAppointmentRepository lawyerAppointmentRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private LawyerScheduleRepository lawyerScheduleRepository;
	
	@PostMapping("/lawyer/appointment/add")
	public LawyerAppointment addLawyerAppointment(@RequestBody LawyerAppointmentDto lawyerAppointmentDto) {
		Optional<Customer> optionalC=customerRepository.findById(lawyerAppointmentDto.getCustomer_id());
		if (!optionalC.isPresent()) {
			throw new RuntimeException(); 
		}
		Customer customer=optionalC.get();
		
		
		Optional<LawyerSchedule> optionalD=lawyerScheduleRepository.findById(lawyerAppointmentDto.getLawyerSchedule_id());
		if (!optionalD.isPresent()) {
			throw new RuntimeException();
		}
		LawyerSchedule lawyerSchedule=optionalD.get();
		
		LawyerAppointment lawyerAppointment=new LawyerAppointment();
		lawyerAppointment.setCustomer(customer);
		lawyerAppointment.setLawyerSchedule(lawyerSchedule);
		lawyerAppointment.setStatus("Not Verified");
		System.out.println(lawyerAppointment);
		return lawyerAppointmentRepository.save(lawyerAppointment);
	}
	
	@GetMapping("/lawyer/appointment/view/all")
	public List<LawyerAppointment> getAllLawyerAppointment() {
		return lawyerAppointmentRepository.findAll();
	}
	
	@GetMapping("/lawyer/appointment/view/{lid}")
	public List<LawyerAppointment> getLawyerAppointmentByLawyerId(@PathVariable("lid") Long lid) {
		return lawyerAppointmentRepository.getLawyerAppointmentByLawyerId(lid);
	}
	
	@GetMapping("/lawyer/user/appointment/view/{uid}")
	public List<LawyerAppointment> getLawyerAppointmentByCustomerId(@PathVariable("uid") Long uid) {
		return lawyerAppointmentRepository.getLawyerAppointmentByCustomerId(uid);
	}
	
	@PutMapping("/lawyer/accept/appointment/{aid}")
	public LawyerAppointment acceptLawyerAppointment(@PathVariable("aid") Long aid) {
		Optional<LawyerAppointment> optionalD=lawyerAppointmentRepository.findById(aid);
		if (!optionalD.isPresent()) {
			throw new RuntimeException();
		}
		LawyerAppointment lawyerAppointment=optionalD.get();
		LawyerAppointment lawyerAppointmentNew=new LawyerAppointment();
		lawyerAppointmentNew.setId(lawyerAppointment.getId());
		lawyerAppointmentNew.setCustomer(lawyerAppointment.getCustomer());
		lawyerAppointmentNew.setLawyerSchedule(lawyerAppointment.getLawyerSchedule());
		lawyerAppointmentNew.setStatus("Accepted");
		return lawyerAppointmentRepository.save(lawyerAppointmentNew);
		
	}
	@PutMapping("/lawyer/reject/appointment/{aid}")
	public LawyerAppointment rejectLawyerAppointment(@PathVariable("aid") Long aid) {
		Optional<LawyerAppointment> optionalD=lawyerAppointmentRepository.findById(aid);
		if (!optionalD.isPresent()) {
			throw new RuntimeException();
		}
		LawyerAppointment lawyerAppointment=optionalD.get();
		LawyerAppointment lawyerAppointmentNew=new LawyerAppointment();
		lawyerAppointmentNew.setId(lawyerAppointment.getId());
		lawyerAppointmentNew.setCustomer(lawyerAppointment.getCustomer());
		lawyerAppointmentNew.setLawyerSchedule(lawyerAppointment.getLawyerSchedule());
		lawyerAppointmentNew.setStatus("Rejected");
		return lawyerAppointmentRepository.save(lawyerAppointmentNew);
		
	}
}
	


