package org.sergey.ans.controller.calculator;

import org.sergey.ans.entity.TwoVariableMathExpression;
import org.sergey.ans.enums.Operation;
import org.sergey.ans.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    public String getCalculatorTemplate(@ModelAttribute("expression")TwoVariableMathExpression expression, Model model) {
        model.addAttribute("operations", Operation.values());
        return "calculator/calculator";
    }

    @PostMapping("/calculation")
    public String calculate(@ModelAttribute("expression") @Valid TwoVariableMathExpression expression,
                            BindingResult bindingResult, Model model) {
        model.addAttribute("operations", Operation.values());
        if (bindingResult.hasErrors()) {
            logger.info(bindingResult.getAllErrors().toString());
        } else {
            double result = calculatorService.calculate(expression.getFirstValue(),
                    expression.getSecondValue(), expression.getOperation().toString());
            expression.setResult(result);
            logger.info(String.valueOf(result));
        }
        return "calculator/calculator";
    }
}
