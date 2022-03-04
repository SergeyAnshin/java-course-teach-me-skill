package org.sergey.ans.controller;

import org.sergey.ans.exception.UserAlreadyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(RuntimeException.class)
    public String showRuntimeException(RuntimeException runtimeException, Model model) {
        model.addAttribute("errorMessage", "sho");
        return "error";
    }

    @ExceptionHandler(UserAlreadyException.class)
    public String showUserAlreadyException(RuntimeException runtimeException, Model model) {
        model.addAttribute("errorMessage", "user already exists");
        return "user/registration";
    }
}
