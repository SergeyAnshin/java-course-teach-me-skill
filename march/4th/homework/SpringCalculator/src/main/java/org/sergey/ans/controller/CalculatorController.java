package org.sergey.ans.controller;

import org.sergey.ans.enums.Operation;
import org.sergey.ans.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculation")
    public String getCalculatorTemplate(Model model) {
        model.addAttribute("operations", Operation.values());
        return "calculator/calculator";
    }

    @PostMapping("/calculation")
    public String calculate(double firstValue, double secondValue, String operation, Model model) {
        if (Operation.contain(operation)) {
            double result = calculatorService.calculate(firstValue, secondValue, operation);
            model.addAttribute("result", result);
        }
        return "forward:/calculator/calculator";
    }
}
