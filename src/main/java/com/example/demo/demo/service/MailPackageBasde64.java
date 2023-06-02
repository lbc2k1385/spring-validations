package com.example.demo.demo.service;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class MailPackageBasde64 {
	
	@NotEmpty(message = "First Name should not be empt")
	private String firstName;
	
	@NotEmpty(message = "Last Name should not be empt")
	private String lastName;
	
	@NotEmpty(message = "Documents cannot be nempty")
	private List<String> documents;

	public List<String> getDocuments() {
		return documents;
	}

	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
