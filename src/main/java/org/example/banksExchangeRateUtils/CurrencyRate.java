package org.example.banksExchangeRateUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.currency.currencies.Currency;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRate {
    private Currency currency;
    private BigDecimal buyRate;
    private BigDecimal sellRate;

}
