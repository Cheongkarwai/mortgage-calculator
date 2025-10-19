package com.cheong.realestatebe.converter;

import java.math.BigDecimal;

public record MortgageCalculation(BigDecimal totalInterest,
                                  BigDecimal totalRepayment,
                                  BigDecimal monthlyRepayment) {
}
