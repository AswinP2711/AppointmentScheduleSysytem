package com.ass.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ass.api.model.DoctorAppointment;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Long>{
	
	@Query("select a from DoctorAppointment a where a.doctorSchedule.doctor.id=?1")
	List<DoctorAppointment> getDoctorAppointmentByDoctorId(Long did);
	
	@Query("select a from DoctorAppointment a where a.customer.id=?1")
	List<DoctorAppointment> getDoctorAppointmentByCustomerId(Long did);

}
