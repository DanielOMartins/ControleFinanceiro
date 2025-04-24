package com.control.finance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@With
public class Income {
    @NotNull
    @PositiveOrZero
    private final BigDecimal netIncome;

    @NotNull
    @PositiveOrZero
    private final BigDecimal marketVoucher;

    @NotNull
    @PositiveOrZero
    private final BigDecimal foodVoucher;

    @NotNull
    private final List<OtherIncome> otherIncome;

    @NotNull
    @PositiveOrZero
    private  BigDecimal totalIncome;
}
