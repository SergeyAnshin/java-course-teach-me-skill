package com.ans.serg.calculatorrestproject.controller;

import com.ans.serg.calculatorrestproject.entity.CalculationResult;
import com.ans.serg.calculatorrestproject.entity.TwoVariableMathExpression;
import com.ans.serg.calculatorrestproject.entity.User;
import com.ans.serg.calculatorrestproject.service.CalculationResultService;
import com.ans.serg.calculatorrestproject.service.CalculatorService;
import com.ans.serg.calculatorrestproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final CalculatorService calculatorService;
    private final CalculationResultService calculationResultService;
    private final UserService userService;

    public UserController(CalculatorService calculatorService, CalculationResultService calculationResultService, UserService userService) {
        this.calculatorService = calculatorService;
        this.calculationResultService = calculationResultService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        if (userService.exists(user)) {
            return ResponseEntity.badRequest().build();
        } else {
            User savedUser = userService.save(user);
            return ResponseEntity.ok(savedUser);
        }
    }

    @PostMapping("/{id}/calculator")
    public ResponseEntity<CalculationResult> calculate(@Valid @RequestBody TwoVariableMathExpression expression,
                                                       @PathVariable("id") long userId) {
        CalculationResult calculationResult = calculatorService.calculate(expression);
        calculationResult.setUser(User.builder()
                .id(userId)
                .build());
        calculationResultService.save(calculationResult);
        return ResponseEntity.ok(calculationResult);
    }

    @GetMapping("/{id}/calculator/calculation-history")
    public ResponseEntity<List<CalculationResult>> getCalculationHistory(@PathVariable("id") long userId) {
        return ResponseEntity.ok(calculationResultService.findAllByUserId(userId));
    }
}
