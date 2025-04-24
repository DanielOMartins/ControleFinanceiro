package com.control.finance.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@With
public class OtherIncome {
    @NotBlank
    private final String name;

    @NotNull
    @PositiveOrZero
    private final BigDecimal balance;
}
