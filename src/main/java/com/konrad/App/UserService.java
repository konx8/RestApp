package com.konrad.App;

import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userRepo == null){
            throw  new UsernameNotFoundException("User not found");
        }
        return userRepo.findByUsername(username);
    }

    public void signUpUser(User user){

        if(userRepo.existsByUsername(user.getUsername())){
            throw new IllegalStateException("User already exist");
        }
        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        user.setRole("USER");
        userRepo.save(user);


    }
    public String login(User user){
        User userFromDB = userRepo.findByUsername(user.getUsername());
        System.out.println(userFromDB.getId());
        boolean passMatches = bCryptPasswordEncoder.matches(user.getPassword(),userFromDB.getPassword());
        if (userFromDB.getUsername().equals(user.getUsername()) && passMatches){
            String token = UUID.randomUUID().toString();
            Token userToken = new Token(
                    token,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(10),
                    user.getUsername()
            );
            tokenService.saveToken(userToken);
            return token;
        }
        return "Wrong data";
    }
}
