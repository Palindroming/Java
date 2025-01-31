package com.example.validaton;


import com.example.validaton.model.API;
import com.example.validaton.model.UseRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;
@RestController

@Slf4j
@RequestMapping("/api/user")
@Validated
public class UseAPIController {

    // MethodArgumentNotValidException

    @PostMapping("")
    public API<UseRegisterRequest> register(

            @Valid
            @RequestBody
            API<UseRegisterRequest> userRegisterRequest

    ){
        log.info("init : {}", userRegisterRequest);

        var body = userRegisterRequest.getData();

        var response = API.<UseRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();

        return response;
    }

}
