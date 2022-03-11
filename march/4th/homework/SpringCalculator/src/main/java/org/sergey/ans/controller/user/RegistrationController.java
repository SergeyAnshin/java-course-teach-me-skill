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

@Controller
@RequestMapping("/user")
public class RegistrationController {
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationTemplate(@ModelAttribute("newUser") User user) {
        return "user/registration";
    }

    @PostMapping("/registration")
    public String signUp(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info(bindingResult.getAllErrors().toString());
        } else {
            boolean isSaved = userService.save(user);
            logger.info(user.toString());
            logger.info(String.valueOf(isSaved));
        }
        return "user/registration";
    }

}
