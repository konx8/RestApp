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
        //userService.registerUser(user);
    }


    @GetMapping("/home")
    public String home(){
        return "HOme";
    }
    @GetMapping("/user")
    public String user(){
        return "user";
    }

}
