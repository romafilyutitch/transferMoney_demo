package com.example.transferMoney.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class TransferBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User from;
    @OneToOne
    private User to;

    private BigDecimal amount;

}
