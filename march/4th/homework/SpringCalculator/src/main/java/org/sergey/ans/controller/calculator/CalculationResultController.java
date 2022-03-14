package org.sergey.ans.controller.calculator;

import org.sergey.ans.service.CalculationResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalculationResultController {
    public final static String ATTRIBUTE_CALCULATION_RESULT = "results";
    public final static String PATH_CALCULATOR_TEMPLATE = "calculator/calculation-results";
    private final CalculationResultService resultService;

    @Autowired
    public CalculationResultController(CalculationResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/calculation-results")
    public String getCalculatorTemplate(Model model) {
        model.addAttribute(ATTRIBUTE_CALCULATION_RESULT, resultService.findAll());
        return PATH_CALCULATOR_TEMPLATE;
    }
}
