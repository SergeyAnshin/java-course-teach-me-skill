package com.ans.serg.calculatorspringboot.controller;

import com.ans.serg.calculatorspringboot.entity.CalculationResult;
import com.ans.serg.calculatorspringboot.entity.TwoVariableMathExpression;
import com.ans.serg.calculatorspringboot.entity.User;
import com.ans.serg.calculatorspringboot.enums.Operation;
import com.ans.serg.calculatorspringboot.service.CalculationResultService;
import com.ans.serg.calculatorspringboot.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static com.ans.serg.calculatorspringboot.controller.UserController.ATTRIBUTE_AUTHENTICATED_USER;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    public static final String NAME_CALCULATOR_VIEW = "calculator/calculator";
    public static final String ATTRIBUTE_EXPRESSION = "expression";
    public static final String ATTRIBUTE_OPERATIONS = "operations";
    public static final String ATTRIBUTE_RESULTS = "results";
    public static final String NAME_CALCULATION_HISTORY_VIEW = "calculator/calculation-history";
    public static final String ATTRIBUTE_RESULT = "result";
    private final CalculatorService calculatorService;
    private final CalculationResultService resultService;
    private final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    public CalculatorController(CalculatorService calculatorService, CalculationResultService resultService) {
        this.calculatorService = calculatorService;
        this.resultService = resultService;
    }

    @GetMapping("/calculation")
    public String getCalculatorTemplate(@ModelAttribute(ATTRIBUTE_EXPRESSION) TwoVariableMathExpression expression,
                                        Model model) {
        model.addAttribute(ATTRIBUTE_OPERATIONS, Operation.values());
        return NAME_CALCULATOR_VIEW;
    }

    @PostMapping("/calculation")
    public String calculate(@ModelAttribute(ATTRIBUTE_EXPRESSION) TwoVariableMathExpression expression,
                            Model model, HttpServletRequest request) {
        model.addAttribute(ATTRIBUTE_OPERATIONS, Operation.values());
        logger.info("CALCULATOR CONTROLLER - CALCULATE: expression is calculated " + expression);
        CalculationResult calculationResult = calculatorService.calculate(expression);
        logger.info("CALCULATOR CONTROLLER - CALCULATE: calculation result " + calculationResult);
        User authenticatedUser = (User) request.getSession().getAttribute(ATTRIBUTE_AUTHENTICATED_USER);
        if (authenticatedUser != null) {
            logger.info("CALCULATOR CONTROLLER - CALCULATE: calculation result is saving to history");
            calculationResult.setUser(authenticatedUser);
            resultService.save(calculationResult);
        }
        model.addAttribute(ATTRIBUTE_RESULT, calculationResult.getResult());
        return NAME_CALCULATOR_VIEW;
    }

    @GetMapping("/calculation-history")
    public String getCalculationHistoryTemplate(Model model, HttpServletRequest request) {
        User authenticatedUser = (User) request.getSession().getAttribute(ATTRIBUTE_AUTHENTICATED_USER);
        if (authenticatedUser != null) {
            model.addAttribute(ATTRIBUTE_RESULTS, resultService.findAllByUser(authenticatedUser));
        }
        return NAME_CALCULATION_HISTORY_VIEW;
    }
}
