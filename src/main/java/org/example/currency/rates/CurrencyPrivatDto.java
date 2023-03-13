package org.example.currency.rates;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.currency.currencies.Currency;

@Getter
@Setter
@ToString
public class CurrencyPrivatDto {
    private Currency ccy;
    private Currency base_ccy;
    private BigDecimal buy;
    private BigDecimal sale;
}
