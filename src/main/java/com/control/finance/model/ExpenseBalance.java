package com.control.finance.model;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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