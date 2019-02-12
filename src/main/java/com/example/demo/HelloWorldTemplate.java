package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldTemplate {
    @RequestMapping("/template")
    public String index(Model model) {
        model.addAttribute("nickname", "sloth");
        model.addAttribute("message", "Hello World!");
        return "template";
    }
}
