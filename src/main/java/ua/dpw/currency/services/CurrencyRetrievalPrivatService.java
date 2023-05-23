package ua.dpw.currency.services;

import static ua.dpw.database.Service.BANK_SERVICE;
import static ua.dpw.database.Service.CURRENCY_SERVICE;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.utils.JsonConverter;

public class CurrencyRetrievalPrivatService implements CurrencyRetrievalService {

    private static final String URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=11";
    private static final Bank BANK = BANK_SERVICE.getByName("PRIVATBANK");

    @Override
    public List<CurrencyRate> getCurrencyRates() {
        try {
            String response = Jsoup.connect(URL).ignoreContentType(true).get().body().text();
            List<JsonObject> responseJson = JsonConverter.convertJsonStringToList(
                response, JsonObject.class);

            return responseJson.stream()
                .map(dto -> new CurrencyRate(
                    BANK,
                    CURRENCY_SERVICE.getByName(dto.get("ccy").getAsString()),
                    dto.get("buy").getAsBigDecimal(),
                    dto.get("sale").getAsBigDecimal()
                ))
                .toList();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
