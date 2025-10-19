package com.cheong.realestatebe.converter;

import org.springframework.ai.converter.FormatProvider;
import org.springframework.core.convert.converter.Converter;

public interface MortgageCalculationConverter<MortgageCalculation> extends Converter<String, MortgageCalculation>, FormatProvider {
}
