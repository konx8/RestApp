package com.konrad.App;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepo itemRepo;
    private final TokenRepo tokenRepo;
    private final UserRepo userRepo;

    public void addItem(String userName){

        User user = userRepo.findByUsername(userName);
        Token token = tokenRepo.findByUserName(userName);
        Item newItem = new Item();
        newItem.setUserId(user.getId());
        newItem.setUserId(token.getUserId());
        itemRepo.save(newItem);

    }

    public List<Item> findAllItems(String userId){
        return itemRepo.findAllByUserId(userId);
    }

}
