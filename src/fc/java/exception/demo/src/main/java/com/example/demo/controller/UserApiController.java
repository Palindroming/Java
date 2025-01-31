package com.example.demo.controller;

import com.example.demo.exception.RestApiExceptionHandler;
import com.example.demo.model.API;
import com.example.demo.model.UserResponse;
import org.apache.catalina.User;
import org.springframework.boot.context.config.ConfigDataException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private static List <UserResponse> userList = List.of(
            UserResponse.builder()
                    .id("1")
                    .age(10)
                    .name("John")
                    .build(),

            UserResponse.builder()
                    .id("2")
                    .age(12)
                    .name("Mike")
                    .build()

            );


    @GetMapping("id/{userId}")
    public API<UserResponse> getuser(
            @PathVariable String userId
    ){

        var user = userList.stream()
                .filter(
                        item -> userId.equals(item.getId())
                )
                .findFirst().get();
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));


        API<UserResponse> response = API.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMsg(HttpStatus.OK.name())
                .data(user)
                .build();

        return response;

    }
}
