package com.konrad.App;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepo extends MongoRepository<Item, String> {

    List<Item> findAllByUserId(String userId);

}
