package com.example.demo.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class DocumentValidator implements ConstraintValidator<ValidDocument, List<MultipartFile>> {



    @Override
    public boolean isValid(List<MultipartFile> value, ConstraintValidatorContext context) {

        if (value == null || value.isEmpty()) {
            return false;
        }

        return true; 
    }
}

