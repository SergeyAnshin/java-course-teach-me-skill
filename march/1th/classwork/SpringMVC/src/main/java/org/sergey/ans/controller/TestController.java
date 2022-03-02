package org.sergey.ans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test(String name, int age, Model model) {
        model.addAttribute("myName", name);
        model.addAttribute("myAge", name);
        return "test";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
