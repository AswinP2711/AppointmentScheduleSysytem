package com.ass.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ass.api.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	@Query("select d from Doctor d where d.user.username=?1")
	Doctor getDoctorDetails(String username);
	
	@Query("select d from Doctor d where d.status=?1")
	Doctor getNotVerifiedDoctor(String con);

}
