package com.example.validaton.validator;


import com.example.validaton.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.DateTimeException;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String birthdate;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
            this.birthdate = constraintAnnotation.birthdate();    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null || s.isEmpty()) {

            return false;

ㅎ    }
    try{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(birthdate);
        java.time.YearMonth.parse(s, formatter);
        return true;
    } catch (DateTimeException e) {
        return false;
    }
}
}