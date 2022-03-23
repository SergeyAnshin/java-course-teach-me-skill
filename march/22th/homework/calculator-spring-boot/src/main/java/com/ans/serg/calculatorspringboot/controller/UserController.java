package com.ans.serg.calculatorspringboot.controller;

import com.ans.serg.calculatorspringboot.dto.user.UserLoginDTO;
import com.ans.serg.calculatorspringboot.dto.user.UserSignupDTO;
import com.ans.serg.calculatorspringboot.entity.User;
import com.ans.serg.calculatorspringboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    public static final String ATTRIBUTE_USER = "user";
    public static final String REDIRECT_TO_LOGIN_URL = "redirect:/user/login";
    public static final String REDIRECT_TO_HOME_URL = "redirect:/";
    public static final String OBJECT_ERROR_GLOBAL = "globalError";
    public static final String ERROR_USER_EXISTS = "User with this email already exists!";
    public static final String ERROR_FAILED_SAVE = "Failed to save user. Please try again!";
    public static final String NAME_SIGNUP_VIEW = "user/signup";
    public static final String NAME_LOGIN_VIEW = "user/login";
    public static final String REDIRECT_TO_CALCULATION_URL = "redirect:/calculator/calculation";
    public static final String ATTRIBUTE_AUTHENTICATED_USER = "authenticatedUser";
    public UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String getSignupTemplate(@ModelAttribute(ATTRIBUTE_USER) UserSignupDTO userSignupDTO) {
        return NAME_SIGNUP_VIEW;
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute(ATTRIBUTE_USER) @Valid UserSignupDTO userSignupDTO,
                         BindingResult bindingResult) {
        logger.info("USER CONTROLLER - SIGNUP: user is registering " + userSignupDTO);
        if (bindingResult.hasErrors()) {
            logger.warn("USER CONTROLLER - SIGNUP: validation errors" + bindingResult.getFieldErrors());
            return NAME_SIGNUP_VIEW;
        } else {
            if (userService.findByEmail(userSignupDTO.getEmail()).isPresent()) {
                bindingResult.addError(new ObjectError(OBJECT_ERROR_GLOBAL, ERROR_USER_EXISTS));
                logger.warn("USER CONTROLLER - SIGNUP: user already exists " + userSignupDTO);
                return NAME_SIGNUP_VIEW;
            } else {
                if (userService.signup(userSignupDTO)) {
                    logger.info("USER CONTROLLER - SIGNUP: user is registered");
                    return REDIRECT_TO_LOGIN_URL;
                } else {
                    bindingResult.addError(new ObjectError(OBJECT_ERROR_GLOBAL, ERROR_FAILED_SAVE));
                    logger.warn("USER CONTROLLER - SIGNUP: user not registered");
                    return NAME_SIGNUP_VIEW;
                }
            }
        }
    }

    @GetMapping("/login")
    public String getLoginTemplate(@ModelAttribute(ATTRIBUTE_USER) UserLoginDTO userLoginDTO) {
        return NAME_LOGIN_VIEW;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(ATTRIBUTE_USER) @Valid UserLoginDTO userLoginDTO, BindingResult bindingResult,
                        HttpServletRequest request) {
        logger.info("USER CONTROLLER - LOGIN: user is logging in " + userLoginDTO);
        if (bindingResult.hasErrors()) {
            logger.warn("USER CONTROLLER - LOGIN: field has error " + bindingResult.getFieldErrors());
            return NAME_LOGIN_VIEW;
        } else {
            Optional<User> authenticatedUser = userService.authenticate(userLoginDTO);
            if (authenticatedUser.isPresent()) {
                logger.info("USER CONTROLLER - LOGIN: user is logged in");
                request.getSession().setAttribute(ATTRIBUTE_AUTHENTICATED_USER, authenticatedUser.get());
                logger.info("USER CONTROLLER - LOGIN: user is adding to session " + authenticatedUser);
                return REDIRECT_TO_CALCULATION_URL;
            } else {
                logger.warn("USER CONTROLLER - LOGIN: authenticate user " + authenticatedUser);
                return NAME_LOGIN_VIEW;
            }
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return REDIRECT_TO_HOME_URL;
    }
}
