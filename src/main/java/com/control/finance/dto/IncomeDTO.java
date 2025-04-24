package com.control.finance.dto;

import com.control.finance.model.Income;
import com.control.finance.model.OtherIncome;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class IncomeDTO {
    private String id;
    private String netIncome;
    private String marketVoucer;
    private String foodVoucher;
    private List<String> otherIncome;
    private String totalIncome;

    public static IncomeDTO from(Income income) {
        return IncomeDTO.builder()
                .id(income.getId())
                .netIncome(String.valueOf(income.getNetIncome()))
                .marketVoucer(String.valueOf(income.getMarketVoucher()))
                .foodVoucher(String.valueOf(income.getFoodVoucher()))
                .otherIncome(income.getOtherIncome().stream().map(OtherIncome::toString).toList())
                .totalIncome(String.valueOf(income.calculateTotalIncome()))
                .build();
    }

    public static Income to(IncomeDTO incomeDTO) {
        return Income.builder()
                .id(incomeDTO.getId())
                .netIncome(new BigDecimal(incomeDTO.getNetIncome()))
                .marketVoucher(new BigDecimal(incomeDTO.getMarketVoucer()))
                .foodVoucher(new BigDecimal(incomeDTO.getFoodVoucher()))
                .otherIncome(getOtherIncomeFrom(incomeDTO.getOtherIncome()))
                .build();
    }

    private static List<OtherIncome> getOtherIncomeFrom(List<String> otherIncome) {
        return otherIncome.stream()
                .map(IncomeDTO::getOtherIncomeFrom)
                .toList();
    }

    private static OtherIncome getOtherIncomeFrom(String incomeStr) {
        String[] parts = incomeStr.split(",");
        return OtherIncome.builder()
                .name(parts[0].split("=")[1])
                .balance(new BigDecimal(parts[1].split("=")[1]))
                .build();
    }
}
