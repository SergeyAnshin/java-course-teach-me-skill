package com.ans.ser.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping
    public String getCalculatorTemplate() {
        return "calc";
    }

    @PostMapping
    public String calculate(String a, String b, String operation, Model model) {
        double result = Double.parseDouble(a + b);
        model.addAttribute("result", result);
        return "calc";
    }
}
