package ua.dpw.currency.rates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;

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