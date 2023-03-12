package org.example.currency.rates;

import java.math.BigDecimal;
import org.example.currency.currencies.Currency;
public class CurrencyNbuDto {
    private Integer r030;
    private String txt;
    private BigDecimal rate;
    private String cc;
    private String exchangedate;
    private Currency currency;

    public CurrencyNbuDto(Integer r030, String txt, BigDecimal rate, String cc, String exchangedate, Currency currency) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }
    public Currency getCurrency(){
        return currency = r030 == 840 ? Currency.USD: Currency.EUR;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
