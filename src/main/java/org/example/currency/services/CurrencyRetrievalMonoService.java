package org.example.currency.services;


import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import org.example.currency.rates.CurrencyRate;
import org.example.currency.rates.CurrencyMonoDto;
import org.example.utils.JsonConverter;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.example.currency.currencies.Currency.EUR;
import static org.example.currency.currencies.Currency.USD;


class CurrencyRetrievalMonoService implements CurrencyRetrievalService {

    private static final String URL = "https://api.monobank.ua/bank/currency";

    private static Map<Integer, Currency> codeCurr = Map.of(
            840, USD,
            978, EUR
    );
    @Override
    public List<CurrencyRate> getCurrencyRates() {
        try {
            String response = Jsoup.connect(URL).ignoreContentType(true).get().body().text();
            List<CurrencyMonoDto> currencyRateResponses =  JsonConverter.convertJsonStringToList(
                    response, CurrencyMonoDto.class);
            return currencyRateResponses.stream()
                    .filter(item -> codeCurr.containsKey(item.getCurrencyCodeA())
                            && codeCurr.containsKey(item.getCurrencyCodeB())
                            && item.getCurrencyCodeB().equals(980)
                    )

                    .map(item -> new CurrencyRate(
                            Bank.MONOBANK,
                            Calendar.getInstance(),
                            codeCurr.get(item.getCurrencyCodeA()),
                            item.getRateSell(),
                            item.getRateBuy()


                    ))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
