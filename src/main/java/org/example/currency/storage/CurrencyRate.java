package org.example.currency.storage;

import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrencyRate {

    private Bank bank;
    private Calendar rateDate;
    private Currency currency;
    private BigDecimal sellingRate;
    private BigDecimal buyingRate;

    public CurrencyRate(Bank bank, Calendar rateDate, Currency currency, BigDecimal sellingRate, BigDecimal buyingRate) {
        this.bank = bank;
        this.rateDate = rateDate;
        this.currency = currency;
        this.sellingRate = sellingRate;
        this.buyingRate = buyingRate;
    }

    public Bank getBank() {
        return bank;
    }

    public Calendar getRateDate() {
        return rateDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getSellingRate() {
        return sellingRate;
    }

    public BigDecimal getBuyingRate() {
        return buyingRate;
    }

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