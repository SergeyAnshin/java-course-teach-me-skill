package com.ans.serg.restsecurity.mapper;

import com.ans.serg.restsecurity.dto.UserSignupDTO;
import com.ans.serg.restsecurity.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private static BCryptPasswordEncoder passwordEncoder;

    public UserMapper(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static User fromUserSignupDTOToUser(UserSignupDTO userSignupDTO) {
        return User.builder()
                .email(userSignupDTO.getEmail())
                .username(userSignupDTO.getUsername())
                .password(passwordEncoder.encode(userSignupDTO.getPassword()))
                .build();
    }

    public static UserDetails fromUserToUserUserDetails(User user) {
        return User.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }
}
