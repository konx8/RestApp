package com.konrad.App;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        user.setRole("USER");
        userService.registerUser(user);
    }


    @GetMapping("/login/{login}")
    public User registerUser(@PathVariable String login){
        return userService.getUser("John");
    }

    @GetMapping("/home")
    public String home(){
        return "HOme";
    }
    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/")
    public String test(){
        return "test";
    }



}
