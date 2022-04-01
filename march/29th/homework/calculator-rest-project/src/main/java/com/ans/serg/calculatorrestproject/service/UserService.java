package com.ans.serg.calculatorrestproject.service;

import com.ans.serg.calculatorrestproject.entity.User;
import com.ans.serg.calculatorrestproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String authorizationHeader) {
        byte[] decode = Base64.getDecoder().decode(authorizationHeader.substring(6));
        String[] emailAndPassword = new String(decode).split(":");
        return userRepository.existsByEmailAndPassword(emailAndPassword[0], emailAndPassword[1]);
    }

    public boolean exists(User user) {
        return userRepository.findByEmail(user.getEmail()).isPresent();
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
