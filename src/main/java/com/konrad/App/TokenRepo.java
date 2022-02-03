package com.konrad.App;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepo extends MongoRepository<Token, String> {

    Optional<Token> findByToken(String token);

    Token findByUserName(String userName);

}
