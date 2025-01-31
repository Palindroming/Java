package com.example.demo.exception;


import com.example.demo.controller.RestAPiBContoller;
import com.example.demo.controller.RestApiController;
import com.example.demo.model.API;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
//@RestControllerAdvice(basePackages = "com.example.demo.controller")
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestAPiBContoller.class})
@Order(1)
public class RestApiExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity exception(
//            Exception e
//    ){
//
//        log.error("ResApiExceptionHandler", e);
//
//        return ResponseEntity.status(200).build();
//
//    }
    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ){
        log.error("IndexOutOfBoundsException", e);

        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity <API> noSuchElement(
            NoSuchElementException e
    ){
        log.error("", e);

        var response =  API.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMsg(HttpStatus.NOT_FOUND.name())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }




}

/*
맞습니다! ResponseEntity<API>는 API를 본문(body)으로 가지는 HTTP 응답을 표현하기 위한 것입니다. 여기서 중요한 점은 API가 제네릭 클래스라는 점입니다. 이 말은, API 내부에서 자료형을 동적으로 지정할 수 있다는 뜻입니다.

즉:

API는 제네릭 클래스이므로, 내부의 data 필드가 여러 자료형을 가질 수 있습니다.
ResponseEntity<API>는 HTTP 응답 객체로, 동적으로 정의된 API 타입 데이터를 포함할 수 있습니다.

 */