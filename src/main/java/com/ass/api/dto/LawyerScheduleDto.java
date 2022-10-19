package com.ass.api.dto;

public class LawyerScheduleDto {
	private String date;
	private String from_time;
	private String to_time;
	private Long lawyer_id;

	public String getDate() {
		return date;
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

	public Long getLawyer_id() {
		return lawyer_id;
	}

	public void setLawyer_id(Long lawyer_id) {
		this.lawyer_id = lawyer_id;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "LawyerScheduleDto [date=" + date + ", from_time=" + from_time + ", to_time=" + to_time + ", lawyer_id="
				+ lawyer_id + "]";
	}
}
