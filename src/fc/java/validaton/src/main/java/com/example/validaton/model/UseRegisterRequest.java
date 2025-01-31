package com.example.validaton.model;


import com.example.validaton.annotation.PhoneNumber;
import com.example.validaton.annotation.YearMonth;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UseRegisterRequest {

    //@NotNull        // != null
    //@NotEmpty       // != null && name != ""
    //@NotBlank       // != null && name != "" && name != "  "
    private String name;

    private String nickName;

    @Size(min = 1 , max = 12)   // 1 ~ 12
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @YearMonth
    private String birthdate;


    @AssertTrue(message = "name or nickName 은 반드시 1개가 존재해야 합니다.")
    public boolean isNameCheck(){

        if(Objects.nonNull(name) && !name.isBlank()){
            return true;
        }

        if(Objects.nonNull(nickName) && !nickName.isBlank()){
            return true;
        }

        return false;
    }
}



/*
Use @Pattern when validating user input, such as checking the format of strings.
Use @JsonFormat when working with JSON serialization/deserialization, especially for date and time fields.
*/
