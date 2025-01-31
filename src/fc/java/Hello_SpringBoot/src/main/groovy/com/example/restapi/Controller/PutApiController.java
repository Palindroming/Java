package com.example.restapi.Controller;


import com.example.restapi.model.PersonalInfo;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiController {


    private static final Logger log = LoggerFactory.getLogger(PutApiController.class);

    @PutMapping("/put")
    public void put(

            @RequestBody
            PersonalInfo PI

    )
    {
        log.info("Request : {}", PI.toString());
    }

}
