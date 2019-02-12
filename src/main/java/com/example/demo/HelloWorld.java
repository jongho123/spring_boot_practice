package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String index() {

        return "Hello World!";
    }
}
