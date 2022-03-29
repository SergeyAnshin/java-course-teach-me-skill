package com.ans.serg.calculatorspringboot.service;

import com.ans.serg.calculatorspringboot.dto.user.UserLoginDTO;
import com.ans.serg.calculatorspringboot.dto.user.UserSignupDTO;
import com.ans.serg.calculatorspringboot.dtoconverter.UserConverter;
import com.ans.serg.calculatorspringboot.entity.User;
import com.ans.serg.calculatorspringboot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userDAO;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> authenticate(UserLoginDTO userLoginDTO) {
        logger.info("USER SERVICE - AUTHENTICATE: " + userLoginDTO + "is logging in");
        return userDAO.findByEmailAndPassword(userLoginDTO.getEmail(), userLoginDTO.getPassword());
    }

    public Optional<User> findByEmail(String email) {
        logger.info("USER SERVICE - FIND BY EMAIL: user is searching by email " + email);
        return userDAO.findByEmail(email);
    }

    public boolean signup(UserSignupDTO userSignupDTO) {
        logger.info("USER SERVICE - SIGNUP: " + userSignupDTO + " is registering");
        logger.info("USER SERVICE - SIGNUP: " + userSignupDTO + " is converted to user");
        User user = UserConverter.convertToUserFromUserSignupDTO(userSignupDTO);
        logger.info("USER SERVICE - SIGNUP: " + "converted user " + user);
        return !userDAO.existsByEmail(user.getEmail()) && userDAO.save(user) != null;
    }
}
