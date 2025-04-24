package com.control.finance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class ExpenseBalance {
    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private BigDecimal balance;

    @NotNull
    private ExpenseCategory category;

    public enum ExpenseCategory {
        ESSENTIAL, NON_ESSENTIAL, VR, VA
    }
}