package com.ans.serg.calculatorspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    public static final String NAME_HOME_TEMPLATE = "home/home";

    @GetMapping
    public String getHomeTemplate() {
        return NAME_HOME_TEMPLATE;
    }
}
