package com.example.validaton.validator;

import com.example.validaton.annotation.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.validation.annotation.Validated;

import java.util.regex.Pattern;

public class Phonenumbervalidator implements ConstraintValidator<PhoneNumber,String> {


    private String regexp;



    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();   }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        boolean result = Pattern.matches(regexp,value);
        return result;

           }
}
