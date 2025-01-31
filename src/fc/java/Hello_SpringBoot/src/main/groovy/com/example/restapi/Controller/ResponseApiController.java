package com.example.restapi.Controller;


import com.example.restapi.model.PersonalInfo;
import groovy.util.logging.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@lombok.extern.slf4j.Slf4j
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {


    @GetMapping("")
    public ResponseEntity<PersonalInfo> pi(){

        var user = new PersonalInfo();
        user.setName("momose");
        user.setUserAge(32);
        user.setPhone("001");

        log.info("user: " + user);


        var response = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);

        return response;

    }
}
