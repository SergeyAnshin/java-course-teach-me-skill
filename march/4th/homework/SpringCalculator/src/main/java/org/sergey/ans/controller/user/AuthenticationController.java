package org.sergey.ans.controller.user;

import org.sergey.ans.entity.User;
import org.sergey.ans.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

import static org.sergey.ans.controller.calculator.CalculatorController.URL_CALCULATOR_CONTROLLER;

@Controller
@RequestMapping("/user")
@PropertySources({
        @PropertySource("classpath:errors.properties"),
})
public class AuthenticationController {
    public final static String ATTRIBUTE_AUTH_USER = "authUser";
    public final static String ATTRIBUTE_USER = "user";
    public final static String PATH_AUTHENTICATION_TEMPLATE = "user/authentication";
    public final static String URL_AUTHENTICATION_CONTROLLER = "/user/auth";

    private final UserService userService;
    private Environment environment;
    private final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    public AuthenticationController(UserService userService, Environment environment) {
        this.userService = userService;
        this.environment = environment;
    }

    @GetMapping("/auth")
    public String getAuthenticationTemplate(@ModelAttribute(ATTRIBUTE_USER) User user) {
        return PATH_AUTHENTICATION_TEMPLATE;
    }

    @PostMapping("/auth")
    public String authenticate(@ModelAttribute(ATTRIBUTE_USER) @Valid User user, BindingResult bindingResult,
                               HttpSession httpSession) {
        Optional<User> authUser = userService.authenticate(user);
        if (authUser.isPresent()) {
            httpSession.setAttribute(ATTRIBUTE_AUTH_USER, authUser.get());
            logger.info(this.getClass().getName() + ": " + httpSession.getAttribute(ATTRIBUTE_AUTH_USER) + " put into the session");
            return "redirect:" + URL_CALCULATOR_CONTROLLER;
        } else {
            bindingResult.addError(new ObjectError("global", Objects.requireNonNull(environment.getProperty("unauthenticated"))));
            logger.info(this.getClass().getName() + ": " + environment.getProperty("unauthenticated"));
            return PATH_AUTHENTICATION_TEMPLATE;
        }
    }
}
