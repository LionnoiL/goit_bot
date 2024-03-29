package ua.dpw.currency.services;

import static ua.dpw.database.Service.BANK_SERVICE;
import static ua.dpw.database.Service.CURRENCY_SERVICE;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.rates.CurrencyRate;

@Slf4j
public class CurrencyRetrievalOschadService implements CurrencyRetrievalService {

    private static final String URL = "https://www.oschadbank.ua/currency-rate";
    private static final Bank BANK = BANK_SERVICE.getByName("OSCHADBANK");

    @Override
    public List<CurrencyRate> getCurrencyRates() {
        log.info("Start oschad rate");
        List<CurrencyRate> result = new ArrayList<>();
        try {
            Document document = Jsoup.connect(URL).get();
            Element currencyRateTable = document.getElementsByTag("tbody").get(1);
            Elements tableRows = currencyRateTable.getElementsByTag("tr");

            result = tableRows.stream()
                .filter(element -> element.select("td:nth-child(2)").text().equals("USD")
                    || element.select("td:nth-child(2)").text().equals("EUR"))
                .map(item -> new CurrencyRate(
                    BANK,
                    CURRENCY_SERVICE.getByName(item.select("td:nth-child(2)").text()),
                    new BigDecimal(
                        item.select("td:nth-child(5)").text().replaceFirst(",", ".")),
                    new BigDecimal(
                        item.select("td:nth-child(4)").text().replaceFirst(",", "."))
                ))
                .toList();
        } catch (IOException e) {
            log.error("Error get rates from Oschadbank api");
        }
        log.info("End oschad rate");
        return result;
    }
}
