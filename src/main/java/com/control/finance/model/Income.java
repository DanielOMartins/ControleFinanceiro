package com.control.finance.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

@Document(collection = "incomes")
@AllArgsConstructor
@Builder
@Data
@With
public class Income {
    @NotNull
    @NotBlank
    @Id
    private final String id;

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

    public BigDecimal calculateTotalIncome() {
        return netIncome.add(marketVoucher).add(foodVoucher)
                .add(otherIncome.stream()
                        .map(OtherIncome::balance)
                        .reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}
