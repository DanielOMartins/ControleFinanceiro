package com.control.finance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@With
public class Expense {
    @NotNull
    private final List<ExpenseBalance> essentialExpenses;

    @NotNull
    private final List<ExpenseBalance> notEssentialExpenses;

    @NotNull
    private  BigDecimal totalEssentialExpenses;

    @NotNull
    private  BigDecimal totalNotEssentialExpenses;

    @NotNull
    private  BigDecimal totalExpenses;
}
