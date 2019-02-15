package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public @ResponseBody
    String addNewUser (@RequestParam String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping("/del")
    public @ResponseBody
    String delUser (@RequestParam String name) {
        userRepository.deleteByName(name);
        return "Deleted";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
