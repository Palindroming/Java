package com.example.restapi.Controller;

import com.example.restapi.model.bookqueryparam;
import groovy.util.logging.Slf4j;

import org.springframework.web.bind.annotation.*;



@lombok.extern.slf4j.Slf4j
@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {


    @GetMapping(path = "/hello")
    public String hello() {
        return "<html><body><h1>Hello Spring Boot</h1></body></html>";
    }

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable("message") String message,
            @PathVariable("age") int age,
            @PathVariable("isMan") boolean isMan
    ) {
        // 로그 출력
        System.out.println("echo message: " + message);
        System.out.println("echo age: " + age);
        System.out.println("echo isMan: " + isMan);

        // 결과 반환
        return String.format("Message: %s, Age: %d, Is Man: %b",
                message.toUpperCase(), age, isMan);
    }


    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam(name = "category") String category,
            @RequestParam(name = "issuedYear") String issuedYear,
                @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issued_day
                           ) {


        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issued_day);



    }


    @GetMapping(path = "/book2")
    public void queryParam(
            @ModelAttribute  bookqueryparam bq

    ) {


        System.out.println(bq);

    }

    // 잘못된 경로 요청 시 처리
    @ExceptionHandler(Exception.class)
    public String handleError(Exception e) {
        return "Invalid request: " + e.getMessage();
    }


    @GetMapping(path = "/plus")
    public int plus(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
        return a + b;
    }


    //TODO Parameter 2가지 int 형태로 받아서 두 수의 덧셈, 곱셈
    //TODO String 타입,

    @DeleteMapping(path = {"/user/{userName}/delete", "/user/{userName}/del"})
    public void delete(@PathVariable("userName") String userName) {
        log.info("User Name: {}", userName);
    }


}
