package org.example.currency.rates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Getter
@AllArgsConstructor
public class CurrencyRate {
    private Bank bank;
    private Calendar rateDate;
    private Currency currency;
    private BigDecimal sellingRate;
    private BigDecimal buyingRate;



    @Override
    public String toString() {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.ms");

        return "CurrencyRate{" + bank +
                ", " + df.format(rateDate.getTime()) +
                ", " + currency +
                ", " + sellingRate +
                ", " + buyingRate +
                '}';
    }
}