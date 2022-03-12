package org.sergey.ans.controller.user;

import org.sergey.ans.entity.User;
import org.sergey.ans.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.sergey.ans.controller.user.AuthenticationController.URL_AUTHENTICATION_CONTROLLER;

@Controller
@RequestMapping("/user")
public class RegistrationController {
    public final static String PATH_REGISTRATION_TEMPLATE = "user/registration";
    public final static String ATTRIBUTE_NEW_USER = "newUser";

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationTemplate(@ModelAttribute(ATTRIBUTE_NEW_USER) User user) {
        return PATH_REGISTRATION_TEMPLATE;
    }

    @PostMapping("/registration")
    public String signUp(@ModelAttribute(ATTRIBUTE_NEW_USER) @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info(this.getClass().getName() + ": " + user.toString() + " not registered");
            logger.info(this.getClass().getName() + ": registration errors = " + bindingResult.getAllErrors());
            return PATH_REGISTRATION_TEMPLATE;
        } else {
            boolean isSaved = userService.save(user);
            logger.info(this.getClass().getName() + ": " + user.toString() + " is registered = " + isSaved);
            return "redirect:" + URL_AUTHENTICATION_CONTROLLER;
        }

    }

}
