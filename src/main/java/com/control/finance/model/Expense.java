package com.control.finance.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Document(collection = "expenses")
@AllArgsConstructor
@Builder
@Data
@With
public class Expense {
    @NotNull
    @NotBlank
    @Id
    private final String id;

    @NotNull
    private List<ExpenseBalance> essentialExpenses;

    @NotNull
    private List<ExpenseBalance> notEssentialExpenses;

    public BigDecimal calculateTotalExpenses() {
        return getTotalFrom(essentialExpenses).add(getTotalFrom(notEssentialExpenses));
    }

    public BigDecimal getTotalFrom(List<ExpenseBalance> expenseBalances){
        return expenseBalances.stream()
                .map(ExpenseBalance::balance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
