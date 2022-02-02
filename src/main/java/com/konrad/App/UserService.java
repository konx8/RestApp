package com.konrad.App;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

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

    public String signUpUser(User user){

        if(userRepo.existsByUsername(user.getUsername())){
            throw new IllegalStateException("User already exist");
        }

        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodePassword);

        userRepo.save(user);

        String token = UUID.randomUUID().toString();

        Token userToken = new Token(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10),
                user

        );

        tokenService.saveToken(userToken);

        return token;
    }

}
