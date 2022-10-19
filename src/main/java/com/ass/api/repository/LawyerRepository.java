package com.ass.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ass.api.model.Lawyer;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
	@Query("select l from Lawyer l where l.user.username=?1")
	Lawyer getLawyerDetails(String username);

	@Query("select l from Lawyer l where l.status=?1")
	Lawyer getNotVerifiedDoctor(String con);

	
}
