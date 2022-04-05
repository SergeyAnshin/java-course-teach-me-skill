package com.ans.serg.swaggerpetstore.entity;

import com.ans.serg.swaggerpetstore.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Pet pet;
    private int quantity;
    private LocalDateTime shipDate;
    private OrderStatus status;
    private boolean complete;
}
