package com.control.finance.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

/**
 * Represents other income sources.
 * <p>
 * This class is used to represent additional income sources that are not part of the main income.
 * It includes the name of the income source and its balance.
 * </p>
 */
@Builder
@With
public record OtherIncome(@NotBlank String name, @NotNull @PositiveOrZero BigDecimal balance) {
    @Override
    public String toString() {
        return "name='" + name +
                ", balance=" + balance;
    }
}
