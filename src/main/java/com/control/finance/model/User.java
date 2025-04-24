package com.control.finance.model;

import java.math.BigDecimal;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "users")
@AllArgsConstructor
@Builder
@Data
@With
public class User {
    @NotNull
    @NotBlank
    @Id
    private final String id;

    @NotBlank
    @Indexed(unique = true)
    private final String username;

    @NotNull
    @DBRef
    private final Income income;

    @NotNull
    @DBRef
    private final Expense expense;

    @NotNull
    private  BigDecimal remainingBalance;

    @NotNull
    private  BigDecimal totalIncome;

    @NotNull
    private  BigDecimal reserve;
}
