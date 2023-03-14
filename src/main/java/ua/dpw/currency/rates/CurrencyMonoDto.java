package ua.dpw.currency.rates;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyMonoDto {
    private Integer currencyCodeA;
    private Integer currencyCodeB;
    private BigDecimal rateBuy;
    private BigDecimal rateSell;
}
