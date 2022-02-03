package com.konrad.App;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.login(user);

    }


}
