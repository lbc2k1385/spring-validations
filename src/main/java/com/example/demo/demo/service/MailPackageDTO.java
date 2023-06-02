package com.example.demo.demo.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.demo.validator.CustomValidator;
import com.example.demo.demo.validator.ValidDocument;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class MailPackageDTO implements Serializable{
	
	private static final long serialVersionUID = 2377184016819623532L;

//	@Valid
//	@NotNull(message = "Address cannot be null")
//	private AddressDTO address;
	
	//@NotEmpty(message = "First Name should not be empt")
	@CustomValidator(message = "First Name should not be empty")
	private String firstName;
	
	//@NotEmpty(message = "Last Name should not be empt")
	@CustomValidator(message = "Last Name should not be empty")
	private String lastName;
	
	
	//@NotNull(message = "Documents should not be empty")
	@ValidDocument(message = "Docs Name should not be empty")
	private List<MultipartFile> files;

//	public AddressDTO getAddress() {
//		return address;
//	}
//
//	public void setAddress(AddressDTO address) {
//		this.address = address;
//	}

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

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	
	
}
