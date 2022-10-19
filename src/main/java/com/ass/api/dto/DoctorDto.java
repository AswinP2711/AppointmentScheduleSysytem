package com.ass.api.dto;

public class DoctorDto {
	private Long id; 
	private String name;
	private String address;
	private String contact;
	private String specialisation;
	private String status;
	public DoctorDto(Long id, String name, String address, String contact, String specialisation, String status) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.specialisation = specialisation;
		this.status = status;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "DoctorDto [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact
				+ ", specialisation=" + specialisation + ", status=" + status + "]";
	}
	
	
	
}
