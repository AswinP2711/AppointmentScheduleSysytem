package com.ass.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DoctorSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String date;
	@Column(nullable = false)
	private String from_time;
	@Column(nullable = false)
	private String to_time;
	@OneToOne
	private Doctor doctor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFrom_time() {
		return from_time;
	}
	public void setFrom_time(String from_time) {
		this.from_time = from_time;
	}
	public String getTo_time() {
		return to_time;
	}
	public void setTo_time(String to_time) {
		this.to_time = to_time;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@Override
	public String toString() { 
		return "DoctorSchedule [id=" + id + ", date=" + date + ", from_time=" + from_time + ", to_time=" + to_time
				+ ", doctor=" + doctor + "]";
	}
}
