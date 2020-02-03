package com.ibm.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {
	
	private int customerId;
	private String name;
	private String email;
	private String contact;
	private String address;
	
	public Customer() {
		super();
	}
	public Customer(int customerId, String name, String email, String contact, String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}
	public int getcustomerId() {
		return customerId;
	}
	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
