package org.sergey.ans.controller.calculator;

import org.sergey.ans.enums.Operation;
import org.sergey.ans.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

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
        model.addAttribute("operations", Operation.values());
        if (Operation.contain(operation)) {
            double result = calculatorService.calculate(firstValue, secondValue, operation);
            logger.info(String.valueOf(result));
            model.addAttribute("result", result);
        }
        return "calculator/calculator";
    }
}
