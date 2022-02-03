package com.konrad.App;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    private String id;
    private String token;
    private LocalDateTime created;
    private LocalDateTime expire;
    private String userId;
    private String userName;

    public Token(String token, LocalDateTime created, LocalDateTime expire, String userName) {
        this.token = token;
        this.created = created;
        this.expire = expire;
        this.userName = userName;
    }
}
