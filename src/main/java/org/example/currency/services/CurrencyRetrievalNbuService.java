package org.example.currency.services;

import org.example.currency.bank.Bank;
import org.example.currency.rates.CurrencyNbuDto;
import org.example.currency.rates.CurrencyRate;
import org.example.utils.JsonConverter;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
class CurrencyRetrievalNbuService implements CurrencyRetrievalService {
    private static final String URLEUR = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&date=&json";
    private static final String URLUSD = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=EUR&date=&json";
    @Override
    public List<CurrencyRate> getCurrencyRates() {
        try {
            String response = Jsoup.connect(URLEUR).ignoreContentType(true).get().body().text();
            List<CurrencyNbuDto> currencyRateResponses = convertToDto(response);
            currencyRateResponses.addAll(convertToDto(Jsoup.connect(URLUSD).ignoreContentType(true).get().body().text()));
            return currencyRateResponses.stream()
                    .map(item -> new CurrencyRate(
                            Bank.NBU,
                            Calendar.getInstance(),
                            item.getCurrency(),
                            item.getRate(),
                            item.getRate()
                    ))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<CurrencyNbuDto> convertToDto(String response) {
        return JsonConverter.convertJsonStringToList(response, CurrencyNbuDto.class);
    }
}
