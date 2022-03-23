package com.ans.serg.calculatorspringboot.dtoconverter;

import com.ans.serg.calculatorspringboot.dto.user.UserSignupDTO;
import com.ans.serg.calculatorspringboot.entity.User;

public class UserConverter {

    public static User convertToUserFromUserSignupDTO(UserSignupDTO userSignupDTO) {
        return User.builder()
                .name(userSignupDTO.getName())
                .email(userSignupDTO.getEmail())
                .password(userSignupDTO.getPassword())
                .birthday(userSignupDTO.getBirthday())
                .build();
    }
}
