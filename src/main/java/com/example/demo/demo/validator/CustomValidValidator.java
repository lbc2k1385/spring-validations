package com.example.demo.demo.validator;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidValidator implements ConstraintValidator<CustomValidator, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty();
    }
    
    public boolean isValid(List<MultipartFile> value,  ConstraintValidatorContext context) {
    	return value != null && !value.isEmpty();
    }
}

