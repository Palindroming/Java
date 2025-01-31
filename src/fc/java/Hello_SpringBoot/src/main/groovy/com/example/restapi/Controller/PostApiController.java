package com.example.restapi.Controller;


import com.example.restapi.model.PersonalInfo;
import com.example.restapi.model.bookRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public String post( @RequestBody bookRequest br){

        System.out.println(br);
        return br.toString();

    }

    @PostMapping("/info")
    public String postInfo( @RequestBody PersonalInfo pr){

        System.out.println(pr);
        return pr.toString();
    }



}
