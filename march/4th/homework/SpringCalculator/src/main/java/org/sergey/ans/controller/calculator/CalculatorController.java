package org.sergey.ans.controller.calculator;

import org.sergey.ans.entity.CalculationResult;
import org.sergey.ans.entity.TwoVariableMathExpression;
import org.sergey.ans.entity.User;
import org.sergey.ans.enums.Operation;
import org.sergey.ans.service.CalculationResultService;
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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.sergey.ans.controller.user.AuthenticationController.ATTRIBUTE_AUTH_USER;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    public final static String ATTRIBUTE_EXPRESSION = "expression";
    public final static String ATTRIBUTE_OPERATIONS = "operations";
    public final static String ATTRIBUTE_RESULT = "result";
    public final static String PATH_CALCULATOR_TEMPLATE = "calculator/calculator";
    public final static String URL_CALCULATOR_CONTROLLER = "/calculator/calculation";

    private final CalculatorService calculatorService;
    private final CalculationResultService resultService;
    private final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    public CalculatorController(CalculatorService calculatorService, CalculationResultService resultService) {
        this.calculatorService = calculatorService;
        this.resultService = resultService;
    }

    @GetMapping("/calculation")
    public String getCalculatorTemplate(@ModelAttribute(ATTRIBUTE_EXPRESSION)TwoVariableMathExpression expression, Model model) {
        model.addAttribute(ATTRIBUTE_OPERATIONS, Operation.values());
        return PATH_CALCULATOR_TEMPLATE;
    }

    @PostMapping("/calculation")
    public String calculate(@ModelAttribute(ATTRIBUTE_EXPRESSION) @Valid TwoVariableMathExpression expression,
                            BindingResult bindingResult, Model model, HttpSession session) {
        model.addAttribute(ATTRIBUTE_OPERATIONS, Operation.values());
        if (bindingResult.hasErrors()) {
            logger.info(this.getClass().getName() + ": validation errors = " + bindingResult.getAllErrors());
        } else {
            logger.info(this.getClass().getName() + ": expression to evaluate = " + expression);

            CalculationResult<TwoVariableMathExpression> calculationResult = calculatorService.calculate(expression);
            calculationResult.setUser((User) session.getAttribute(ATTRIBUTE_AUTH_USER));
            logger.info(this.getClass().getName() + ": calculated result = " + calculationResult);

            boolean isResultSaved = resultService.save(calculationResult);
            logger.info(this.getClass().getName() + ": calculated result saved  = " + isResultSaved);

            model.addAttribute(ATTRIBUTE_RESULT, calculationResult.getResult());
        }
        return PATH_CALCULATOR_TEMPLATE;
    }
}
