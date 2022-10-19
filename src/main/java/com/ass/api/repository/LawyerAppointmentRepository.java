package com.ass.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ass.api.model.LawyerAppointment;

public interface LawyerAppointmentRepository extends JpaRepository <LawyerAppointment,Long> {
	
	@Query("select a from LawyerAppointment a where a.lawyerSchedule.lawyer.id=?1")
	List<LawyerAppointment> getLawyerAppointmentByLawyerId(Long lid);
	
	@Query("select a from LawyerAppointment a where a.customer.id=?1")
	List<LawyerAppointment> getLawyerAppointmentByCustomerId(Long uid);

}
