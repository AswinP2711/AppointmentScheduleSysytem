package com.ass.api.dto;

public class CustomerDto {
	private Long id;
	private String name;
	private String date_of_birth;
	private String phone_no;
	private String city;
	
	public CustomerDto(Long id, String name, String date_of_birth, String phone_no, String city) {
		super();
		this.id = id;
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.phone_no = phone_no;
		this.city = city;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", name=" + name + ", date_of_birth=" + date_of_birth + ", phone_no="
				+ phone_no + ", city=" + city + "]";
	}
	
	
}
