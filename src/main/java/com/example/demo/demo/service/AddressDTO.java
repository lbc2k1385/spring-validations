package com.example.demo.demo.service;


import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



public class AddressDTO implements Serializable{
	
	
	private static final long serialVersionUID = -7328186606749544951L;

	@NotEmpty(message = "Street should not be empty")
	private String street;
	
	@NotEmpty(message = "City should not be empty")
	private String city;
	
	@NotEmpty(message = "State should not be empty")
	private String state;
	
	@NotEmpty(message = "Zip should not be empty")
	private String zip;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
