package ua.dpw.currency.services;

import static ua.dpw.database.Service.BANK_SERVICE;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.database.Service;
import ua.dpw.utils.JsonConverter;

@Slf4j
class CurrencyRetrievalNbuService implements CurrencyRetrievalService {

    private static final String URL_EUR = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&date=&json";
    private static final String URL_USD = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=EUR&date=&json";
    private static final Bank BANK = BANK_SERVICE.getByName("NBU");

    private static List<JsonObject> convertToDto(String response) {
        return JsonConverter.convertJsonStringToList(response, JsonObject.class);
    }

    @Override
    public List<CurrencyRate> getCurrencyRates() {
        log.info("Start nbu rate");
        List<CurrencyRate> result = new ArrayList<>();
        try {
            String response = Jsoup.connect(URL_EUR).ignoreContentType(true).get().body().text();

            List<JsonObject> currencyRateResponses = convertToDto(response);
            currencyRateResponses.addAll(
                convertToDto(Jsoup.connect(URL_USD).ignoreContentType(true).get().body().text()));
            result = currencyRateResponses.stream()
                .map(item -> new CurrencyRate(
                    BANK,
                    Service.CURRENCY_SERVICE.getByCode(item.get("r030").getAsInt()),
                    item.get("rate").getAsBigDecimal(),
                    item.get("rate").getAsBigDecimal()
                ))
                .toList();
        } catch (IOException e) {
            log.error("Error get rates from NBU api");
        }
        log.info("End nbu rate");
        return result;
    }
}
