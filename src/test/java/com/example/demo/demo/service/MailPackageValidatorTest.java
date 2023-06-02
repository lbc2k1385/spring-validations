package com.example.demo.demo.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.demo.demo.validator.MailPackageValidator;

public class MailPackageValidatorTest {

	@Test
    public void testHandleValidationException() {
        // Mocking the BindingResult and FieldError
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError = new FieldError("objectName", "fieldName", "Error message");

        // Adding the field error to the BindingResult
        when(bindingResult.getAllErrors()).thenReturn(List.of(fieldError));
        
        // Creating a mock MethodArgumentNotValidException
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        when(exception.getBindingResult()).thenReturn(bindingResult);

        // Call the method under test with the mock exception
        MailPackageValidator validator = new MailPackageValidator(); // Instantiate your class or get it from somewhere
        ResponseEntity<List<String>> response = validator.handleValidationExceptions(exception);

        // Assert the response
        List<String> expectedErrors = List.of("Error message");
        assertEquals(ResponseEntity.badRequest().body(expectedErrors), response);
    }
}