package com.example.validaton.model;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class API<T> {

    @Valid
    private T data;

    private String resultCode;

    private String resultMessage;

    private API.Error errors;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Error{

        private List<String> errorMessage;
    }
}
