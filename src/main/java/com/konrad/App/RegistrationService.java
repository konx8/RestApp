package com.konrad.App;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;

    public String register(RegistrationRequest request) {

        return userService.signUpUser(
                new User(
                        request.getUsername(),
                        request.getPassword()
                ));

    }
}
