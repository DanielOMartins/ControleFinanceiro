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
@Data
@With
public class OtherIncome {
    @NotBlank
    private final String name;

    @NotNull
    @PositiveOrZero
    private final BigDecimal balance;
}
