package com.fee.managefeeapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HelloWorldController {
    @GetMapping("/")
    public String helloWorld() {
        return "hello world";
    }
}
