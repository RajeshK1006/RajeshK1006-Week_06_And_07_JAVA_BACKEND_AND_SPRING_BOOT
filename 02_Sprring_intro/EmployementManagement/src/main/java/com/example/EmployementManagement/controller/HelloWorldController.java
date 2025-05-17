package com.example.EmployementManagement.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {


    @GetMapping("/")
    public String hello() {
        return "Hello, World BridgeLabz!";
    }

    // to pass the parameter in the query
    @GetMapping("/hello/query")
    public String helloQueryParam(@RequestParam String name){
        return "Hello " + name + "!";
    }


    @GetMapping("/hello/{name}")
    public String helloPathVariable(@PathVariable String name){
        return "HELLO, "+ name + "!";
    }


    @PostMapping("/hello/body")
    public String helloBody(@RequestBody String name) {
        return "Hello, " + name + "!";
    }



}

