package com.ans.serg.calculatorspringboot.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class User extends Entity {
    private String name;
    @EqualsAndHashCode.Include
    private String email;
    private String password;
    private Date birthday;
    private List<CalculationResult> calculationResults;
}
