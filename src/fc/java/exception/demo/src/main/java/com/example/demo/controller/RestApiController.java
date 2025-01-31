package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping( "/api")
public class RestApiController {

    @GetMapping
    public void hello(){

        var list = List.of("hello");

        var element = list.get(1);
        log.info("element: {}", element); //list 안에 hello 하나 밖에 없기 때문에



        throw  new RuntimeException("run time exception call");
    }


}
