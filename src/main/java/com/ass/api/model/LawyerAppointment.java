package com.ass.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LawyerAppointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Customer customer;
	@OneToOne
	private LawyerSchedule lawyerSchedule;
	@Column(nullable = false)
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LawyerSchedule getLawyerSchedule() {
		return lawyerSchedule;
	}
	public void setLawyerSchedule(LawyerSchedule lawyerSchedule) {
		this.lawyerSchedule = lawyerSchedule;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LawyerAppointment [id=" + id + ", customer=" + customer + ", lawyerSchedule=" + lawyerSchedule
				+ ", status=" + status + "]";
	}
	
}
