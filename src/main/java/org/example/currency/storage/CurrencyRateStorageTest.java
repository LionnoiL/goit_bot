package org.example.currency.storage;

import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class CurrencyRateStorageTest {

    public static void main(String[] args) {

        // Тест збереження курсів у кеш

        BigDecimal sellingRate = new BigDecimal("38.685698898989");
        BigDecimal buyingRate = new BigDecimal("38.822430994039");

        ArrayList<CurrencyRate> rates = new ArrayList<>();

        CurrencyRate currencyRateUSD = new CurrencyRate(Bank.MONOBANK, new GregorianCalendar(), Currency.USD, sellingRate, buyingRate);
        CurrencyRate currencyRateEUR = new CurrencyRate(Bank.MONOBANK, new GregorianCalendar(), Currency.EUR, sellingRate, buyingRate);

        rates.add(currencyRateUSD);
        rates.add(currencyRateEUR);

        CurrencyRateStorage.saveRateToCache(Bank.MONOBANK, rates);

        // Тест отримання повідомлення з курсами для бота

        List<Currency> currencyList = new ArrayList<>();
        currencyList.add(Currency.EUR);
        currencyList.add(Currency.USD);

        String message = CurrencyRateStorage.getFormattedRateBotMessage(3, Bank.MONOBANK, currencyList);
        System.out.println(message);

    }

}
