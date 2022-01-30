package com.konrad.App;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public void registerUser(User user){
        userRepo.save(user);
    }

    public boolean userExist(String login){

        List<User> userList= getUsers();
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User getUser(String login){
        return userRepo.findByLogin(login);
    }




}
