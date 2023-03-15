package ua.dpw.currency.rates;

import java.math.BigDecimal;
import lombok.Data;
import ua.dpw.currency.currencies.Currency;

@Data
public class CurrencyNbuDto {

    private Integer r030;
    private String txt;
    private BigDecimal rate;
    private String cc;
    private String exchangedate;
    private Currency currency;

    public Currency getCurrency() {
        Currency currency = Currency.EUR;
        if (r030 == 840) {
            currency = Currency.USD;
        }
        return currency;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
