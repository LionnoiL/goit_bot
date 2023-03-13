package org.example.currency.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.currency.bank.Bank;
import org.example.currency.rates.CurrencyNbuDto;
import org.example.currency.rates.CurrencyRate;
import org.example.utils.JsonConverter;
import org.jsoup.Jsoup;

class CurrencyRetrievalNbuService implements CurrencyRetrievalService {

    private static final Logger LOG = LogManager.getLogger(CurrencyRetrievalNbuService.class);
    private static final String URL_EUR = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&date=&json";
    private static final String URL_USD = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=EUR&date=&json";

    private static List<CurrencyNbuDto> convertToDto(String response) {
        return JsonConverter.convertJsonStringToList(response, CurrencyNbuDto.class);
    }

    @Override
    public List<CurrencyRate> getCurrencyRates() {
        try {
            String response = Jsoup.connect(URL_EUR).ignoreContentType(true).get().body().text();
            List<CurrencyNbuDto> currencyRateResponses = convertToDto(response);
            currencyRateResponses.addAll(
                convertToDto(Jsoup.connect(URL_USD).ignoreContentType(true).get().body().text()));
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
            LOG.warn("Error get rates from NBU api");
        }
        return new ArrayList<>();
    }
}
