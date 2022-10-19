package com.ass.api.dto;

public class LawyerAppointmentDto {
private Long customer_id;
private  Long lawyerSchedule_id;
public Long getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(Long customer_id) {
	this.customer_id = customer_id;
}
public Long getLawyerSchedule_id() {
	return lawyerSchedule_id;
}
public void setLawyerSchedule_id(Long lawyerSchedule_id) {
	this.lawyerSchedule_id = lawyerSchedule_id;
}
@Override
public String toString() {
	return "LawyerAppointmentDto [customer_id=" + customer_id + ", lawyerSchedule_id=" + lawyerSchedule_id + "]";
}


}
