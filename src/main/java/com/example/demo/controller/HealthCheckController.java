package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthCheckController {

    @GetMapping("/")
    public String healthCheck() {
        log.info("healthCheck 200 OK ");
        return "OK";
    }
}
