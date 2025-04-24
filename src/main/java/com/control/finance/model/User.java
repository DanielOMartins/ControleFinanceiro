package com.control.finance.model;

import java.math.BigDecimal;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@With
public class User {
    @NotNull
    @NotBlank
    private final int id;

    @NotBlank
    private final String username;

    @NotNull
    private final Income income;

    @NotNull
    private final Expense expense;

    @NotNull
    private  BigDecimal remainingBalance;

    @NotNull
    private  BigDecimal totalIncome;

    @NotNull
    private  BigDecimal reserve;
}
