package com.control.finance.dto;

import com.control.finance.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String id;
    private String username;
    private String incomeId;
    private String expenseId;
    private String remainingBalance;
    private String totalIncome;
    private String reserve;

    public static UserDTO from(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .incomeId(user.getIncome().getId())
                .expenseId(user.getExpense().getId())
                .remainingBalance(user.getRemainingBalance().toString())
                .totalIncome(user.getTotalIncome().toString())
                .reserve(user.getReserve().toString())
                .build();
    }
}
