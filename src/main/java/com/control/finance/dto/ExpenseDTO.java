package com.control.finance.dto;

import com.control.finance.model.Expense;
import com.control.finance.model.ExpenseBalance;
import com.control.finance.model.OtherIncome;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ExpenseDTO {
    private String id;
    private List<String> essentialExpenses;
    private List<String> notEssentialExpenses;
    private String totalExpenses;

    public static ExpenseDTO from(Expense expense) {
        return ExpenseDTO.builder()
                .id(expense.getId())
                .essentialExpenses(expense.getEssentialExpenses().stream().map(ExpenseBalance::toString).toList())
                .notEssentialExpenses(expense.getNotEssentialExpenses().stream().map(ExpenseBalance::toString).toList())
                .totalExpenses(String.valueOf(expense.calculateTotalExpenses()))
                .build();
    }

    public static Expense to(ExpenseDTO expenseDTO) {
        return Expense.builder()
                .id(expenseDTO.getId())
                .essentialExpenses(getExpensesFrom(expenseDTO.getEssentialExpenses()))
                .notEssentialExpenses(getExpensesFrom(expenseDTO.getNotEssentialExpenses()))
                .build();
    }

    private static List<ExpenseBalance> getExpensesFrom(List<String> expenses) {
        return expenses.stream()
                .map(ExpenseDTO::getExpenseFrom)
                .toList();
    }

    private static ExpenseBalance getExpenseFrom(String incomeStr) {
        String[] parts = incomeStr.split(",");
        return ExpenseBalance.builder()
                .name(parts[0].split("=")[1])
                .balance(new BigDecimal(parts[1].split("=")[1]))
                .isEssential(Boolean.parseBoolean(parts[2].split("=")[1]))
                .isMarketVoucher(Boolean.parseBoolean(parts[3].split("=")[1]))
                .isFoodVoucher(Boolean.parseBoolean(parts[4].split("=")[1]))
                .build();
    }
}
