package com.ass.api.dto;

public class DoctorAppointmentDto {
	private Long customer_id;
	private Long doctorSchedule_id;
	
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public Long getDoctorSchedule_id() {
		return doctorSchedule_id;
	}
	public void setDoctorSchedule_id(Long doctorSchedule_id) {
		this.doctorSchedule_id = doctorSchedule_id;
	}
	@Override
	public String toString() {
		return "DoctorAppointmentDto [customer_id=" + customer_id + ", doctorSchedule_id=" + doctorSchedule_id + "]";
	}
	
	
	
}
