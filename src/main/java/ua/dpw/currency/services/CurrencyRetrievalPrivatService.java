package ua.dpw.currency.services;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.rates.CurrencyPrivatDto;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.utils.JsonConverter;

public class CurrencyRetrievalPrivatService implements CurrencyRetrievalService {

    private static final String URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=11";

    @Override
    public List<CurrencyRate> getCurrencyRates() {
        try {
            String response = Jsoup.connect(URL).ignoreContentType(true).get().body().text();
            List<CurrencyPrivatDto> responseDtos = JsonConverter.convertJsonStringToList(
                response, CurrencyPrivatDto.class);
            return responseDtos.stream()
                .map(dto -> new CurrencyRate(Bank.PRIVATBANK,
                    Calendar.getInstance(),
                    dto.getCcy(),
                    dto.getSale(),
                    dto.getBuy()
                ))
                .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
