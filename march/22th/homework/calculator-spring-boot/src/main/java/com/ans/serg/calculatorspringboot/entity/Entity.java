package com.ans.serg.calculatorspringboot.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
public abstract class Entity {
    private long id;
    private final LocalDateTime creationDateTime = LocalDateTime.now();
    private final LocalDateTime updateDateTime = LocalDateTime.now();
}
