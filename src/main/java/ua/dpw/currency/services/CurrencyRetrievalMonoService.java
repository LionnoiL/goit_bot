package ua.dpw.currency.services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.currency.rates.CurrencyMonoDto;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.utils.JsonConverter;


class CurrencyRetrievalMonoService implements CurrencyRetrievalService {

    private static final Logger LOG = LogManager.getLogger(CurrencyRetrievalMonoService.class);
    private static final String URL = "https://api.monobank.ua/bank/currency";

    private static Map<Integer, Currency> codeCurr = Map.of(
        Currency.USD.getId(), Currency.USD,
        Currency.EUR.getId(), Currency.EUR
    );

    @Override
    public List<CurrencyRate> getCurrencyRates() {
        try {
            String response = Jsoup.connect(URL).ignoreContentType(true).get().body().text();
            List<CurrencyMonoDto> currencyRateResponses = JsonConverter.convertJsonStringToList(
                response, CurrencyMonoDto.class);
            return currencyRateResponses.stream()
                .filter(item -> (codeCurr.containsKey(item.getCurrencyCodeA())
                    || codeCurr.containsKey(item.getCurrencyCodeB()))
                    && item.getCurrencyCodeB().equals(Currency.UAH.getId()))
                .map(item -> new CurrencyRate(
                    Bank.MONOBANK,
                    Calendar.getInstance(),
                    codeCurr.get(item.getCurrencyCodeA()),
                    item.getRateSell(),
                    item.getRateBuy()))
                .collect(Collectors.toList());
        } catch (IOException e) {
            LOG.warn("Error get rates from Monobank api");
        }
        return new ArrayList<>();
    }
}
