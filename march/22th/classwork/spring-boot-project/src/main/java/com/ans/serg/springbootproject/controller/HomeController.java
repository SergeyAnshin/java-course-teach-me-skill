package com.ans.serg.springbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ModelAndView getHomeTemplate(ModelAndView modelAndView) {
        modelAndView.setViewName("homepage/home");
        return modelAndView;
    }
}
