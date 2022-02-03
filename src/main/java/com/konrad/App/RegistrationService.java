package com.konrad.App;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;

    public void register(RegistrationRequest request) {

         userService.signUpUser(
                new User(
                        request.getUsername(),
                        request.getPassword()
                ));

    }
}
