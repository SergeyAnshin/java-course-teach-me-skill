package com.ans.serg.calculatorrestproject.controller;

import com.ans.serg.calculatorrestproject.entity.CalculationResult;
import com.ans.serg.calculatorrestproject.entity.TwoVariableMathExpression;
import com.ans.serg.calculatorrestproject.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculation")
    public ResponseEntity<CalculationResult> calculate(@Valid @RequestBody TwoVariableMathExpression expression) {
        return ResponseEntity.ok(calculatorService.calculate(expression));
    }
}
