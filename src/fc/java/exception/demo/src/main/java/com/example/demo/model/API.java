package com.example.demo.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
/*The @JsonNaming annotation in the given code is used to specify a naming strategy for how property names in a Java class are serialized or deserialized when working with JSON data. Specifically, the PropertyNamingStrategies.SnakeCaseStrategy.class defines the use of the snake_case naming convention.

*/
public class API<T> {

    private String resultCode;

    private String resultMsg;


    private T data;
    /*The type of data in API<T> depends on what is passed to T. In this case, it is UserResponse. */

}
