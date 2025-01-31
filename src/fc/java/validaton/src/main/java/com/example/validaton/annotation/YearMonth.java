package com.example.validaton.annotation;


import com.example.validaton.validator.Phonenumbervalidator;
import com.example.validaton.validator.YearMonthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = YearMonthValidator.class)

public @interface YearMonth {

    String message() default "생년월일 양식에 맞지 않습니다 ex)YYYYMM";

    String birthdate() default "yyyyMM";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
