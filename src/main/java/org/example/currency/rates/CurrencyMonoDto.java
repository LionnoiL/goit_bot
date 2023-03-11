package org.example.currency.rates;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyMonoDto {
    private Integer currencyCodeA;
    private Integer currencyCodeB;
    private BigDecimal rateBuy;
    private BigDecimal rateSell;
}
