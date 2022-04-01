package com.ans.serg.calculatorrestproject.entity;

import com.ans.serg.calculatorrestproject.enums.Operation;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Entity
@Table
public class TwoVariableMathExpression {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private Double firstValue;

    @NotNull
    private Double secondValue;

    @NotNull
    private Operation operation;

    @OneToOne(mappedBy = "expression")
    private CalculationResult calculationResult;
}
