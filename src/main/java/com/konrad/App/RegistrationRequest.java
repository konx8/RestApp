package com.konrad.App;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequest {

    private final String firstName;
    private final String username;
    private final String email;
    private final String password;

}
