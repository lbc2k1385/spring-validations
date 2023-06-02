package com.example.demo.demo.rest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.demo.service.DemoBean;
import com.example.demo.demo.service.MailPackageBasde64;
import com.example.demo.demo.service.MailPackageDTO;

import jakarta.validation.Valid;



@RestController
public class FunRestController {
		
	private final DemoBean demoBean;
	
	@Autowired
	public FunRestController(DemoBean demoBean) {
		this.demoBean = demoBean;
	}
		
	@PostMapping(value = "/multiPart",
				 consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
				 produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> accept(@RequestBody MultipartFile file) {
		
	    try {
	        file.transferTo(new File("transferred_" + file.getOriginalFilename()));
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    
		return ResponseEntity.ok("Valid");
	}
	
	//Can't use @RequestBody when embedding file in dto
	@PostMapping("/multiPart/v2")
	public ResponseEntity<String> accept(@Valid MailPackageDTO dto) {
		
	    System.out.print(dto);
	    
		return ResponseEntity.ok("Valid");
	}
	
	@PostMapping(value = "/base64",
				 consumes = {MediaType.APPLICATION_JSON_VALUE},
				 produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> accept(@Valid @RequestBody MailPackageBasde64 mailPackage) {

		StringJoiner joiner = new StringJoiner(",");
		mailPackage.getDocuments().stream().forEach(doc -> {
			byte[] decodedBytes = Base64.getDecoder().decode(doc);
			String decodedText = new String(decodedBytes, StandardCharsets.UTF_8);
			joiner.add(decodedText);
		});
		

		return ResponseEntity.ok("Valid: " + joiner);
	}

	


}
