package com.example.demo.demo.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomValidValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomValidator {
    String message() default "Validation error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
