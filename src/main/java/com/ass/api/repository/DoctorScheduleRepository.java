package com.ass.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ass.api.model.DoctorSchedule;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long>{

}
