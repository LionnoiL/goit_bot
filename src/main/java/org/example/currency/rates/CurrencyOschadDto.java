package org.example.currency.rates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyOschadDto {
    private Currency currency;
    private BigDecimal buyRate;
    private BigDecimal sellRate;
    private Bank bank;
}

