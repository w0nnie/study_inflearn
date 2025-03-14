package com.example.secondservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
public class SecondServiceController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to second service.";
    }

    @GetMapping("/message")
    public String message(HttpServletRequest request) {
        String header = request.getHeader("second-request");
        System.out.println(header);
        return "message to second service.";
    }
}
