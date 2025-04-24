package com.control.finance.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

/**
 * Represents expenses sources.
 * <p>
 * This class is used to represent expenses sources.
 * It includes the name of the expense source, its balance and if it is essential, market voucher, food voucher or not.
 * </p>
 */
@Builder
@With
public record ExpenseBalance(@NotBlank String name, @NotNull @PositiveOrZero BigDecimal balance,
                             @NotNull boolean isEssential, @NotNull boolean isMarketVoucher,
                             @NotNull boolean isFoodVoucher) {
    @Override
    public String toString() {
        return "name='" + name  +
                ", balance=" + balance +
                ", essential=" + isEssential +
                ", marketVoucher=" + isMarketVoucher +
                ", foodVoucher=" + isFoodVoucher;
    }
}