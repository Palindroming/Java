package com.example.restapi;


import com.example.restapi.model.PersonalInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestApiApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() throws JsonProcessingException {

        var user = new PersonalInfo();
        user.setName("홍길동");
        user.setUserAge(10);
        user.setPhone("galaxy");
        user.setIs_korean(true);

        var json = objectMapper.writeValueAsString(user);
        System.out.println(json);


        var dto = objectMapper.readValue(json, PersonalInfo.class);
        System.out.println(dto);

    }
}
