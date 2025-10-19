package com.cheong.realestatebe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MortgageRequest {

    private BigDecimal loanAmount;
    private int loanTerm;
    private double interestRate;
    private Frequency repaymentFrequency;

    public Map<String, Object> getMap(){
        return Map.of("loanAmount", loanAmount,
                "loanTerm", loanTerm,
                "interestRate", interestRate,
                "repaymentFrequency", repaymentFrequency.name());
    }

    public enum Frequency {
        MONTHLY
    }
}
