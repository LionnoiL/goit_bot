package org.example.currency.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.stream.Collectors;

public class CurrencyRetrievalOschadService implements CurrencyRetrievalService {

    private static final String URL = "https://www.oschadbank.ua/currency-rate";

    @Override
    public List<CurrencyRateDto> getCurrencyRates() {

        try {
            Document document = Jsoup.connect(URL).get();
            Element currencyRateTable = document.getElementsByTag("tbody").get(1);
            Elements tableRows = currencyRateTable.getElementsByTag("tr");

            return tableRows.stream()
                    .filter(element -> element.select("td:nth-child(2)").text().equals("USD")
                            || element.select("td:nth-child(2)").text().equals("EUR"))
                    .map(item -> {
                        CurrencyOschadDto dto = new CurrencyOschadDto();
                        dto.setCurrency(Currency.valueOf(item.select("td:nth-child(2)").text()));
                        dto.setBuyRate(new BigDecimal(item.select("td:nth-child(4)").text().replaceFirst(",", ".")));
                        dto.setSellRate(new BigDecimal(item.select("td:nth-child(5)").text().replaceFirst(",", ".")));
                        dto.setBankName(Bank.OSCHADBANK);
                        return dto;
                    })
                    .map(item -> new CurrencyRateDto(item.getCurrency(), item.getBuyRate(), item.getSellRate(), item.getBankName()))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
