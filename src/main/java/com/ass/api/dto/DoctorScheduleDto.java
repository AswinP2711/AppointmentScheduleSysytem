package com.ass.api.dto;

public class DoctorScheduleDto {
	private String date;
	private String from_time;
	private String to_time;
	private Long doctor_id;
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
	public Long getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
	}
	@Override
	public String toString() {
		return "DoctorScheduleDto [date=" + date + ", from_time=" + from_time + ", to_time=" + to_time + ", doctor_id="
				+ doctor_id + "]";
	}
	
}
