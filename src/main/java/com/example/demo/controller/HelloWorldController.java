package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(){
        return "<h1>hello</h1>";
    }
}
