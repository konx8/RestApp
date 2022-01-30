package com.konrad.App;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Users {

    @Id
    private String id;
    private String login;
    private String password;

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
