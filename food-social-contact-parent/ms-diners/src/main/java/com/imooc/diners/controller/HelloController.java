package com.imooc.diners.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    // http://localhost:8081/hello?name=redis
    // http://localhost/hello?name=redis
    @GetMapping
    public String hello(String name) {
        return "hello " + name;
    }

}
