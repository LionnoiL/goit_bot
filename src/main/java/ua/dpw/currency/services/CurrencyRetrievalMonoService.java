package ua.dpw.currency.services;

import static ua.dpw.database.Service.BANK_SERVICE;
import static ua.dpw.database.Service.CURRENCY_SERVICE;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.utils.JsonConverter;

@Slf4j
class CurrencyRetrievalMonoService implements CurrencyRetrievalService {

    private static final String URL = "https://api.monobank.ua/bank/currency";
    private static final Bank BANK = BANK_SERVICE.getByName("MONOBANK");

    private static Map<Integer, Currency> codeCurr = Map.of(
        CURRENCY_SERVICE.getByName("USD").getCode(), CURRENCY_SERVICE.getByName("USD"),
        CURRENCY_SERVICE.getByName("EUR").getCode(), CURRENCY_SERVICE.getByName("EUR")
    );

    @Override
    public List<CurrencyRate> getCurrencyRates() {
        Currency uah = CURRENCY_SERVICE.getByName("UAH");

        try {
            String response = Jsoup.connect(URL).ignoreContentType(true).get().body().text();
            List<JsonObject> responseJson = JsonConverter.convertJsonStringToList(
                response, JsonObject.class);

            return responseJson.stream()
                .filter(item -> codeCurr.containsKey(item.get("currencyCodeA").getAsInt())
                    && item.get("currencyCodeB").getAsInt() == uah.getCode())
                .map(item -> new CurrencyRate(
                    BANK,
                    codeCurr.get(item.get("currencyCodeA").getAsInt()),
                    item.get("rateSell").getAsBigDecimal(),
                    item.get("rateBuy").getAsBigDecimal()
                ))
                .toList();
        } catch (IOException e) {
            log.error("Error get rates from Monobank api");
        }
        return new ArrayList<>();
    }
}
