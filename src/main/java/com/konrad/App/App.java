package com.konrad.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@SpringBootApplication

public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

    public static class TokenService {
    }

	@Repository
	public static interface TokenRepo extends MongoRepository<Token, String> {

		Optional<Token> findByToken(String token);
	}
}
