package ua.dpw.currency.services;

import static ua.dpw.utils.JsonConverter.GSON;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.users.User;

public class CurrencyRateCryptoService {

    private static final String URL_BTC = "https://api.bitaps.com/market/v1/ticker/btcusd";
    private static final String URL_ETH = "https://api.bitaps.com/market/v1/ticker/ethusd";

    public String cryptoInfo(User user) {
        List<Currency> userCurrencies = user.getCurrencies();
        StringBuilder result = new StringBuilder();
        try {
            if (userCurrencies.contains(Currency.BITCOIN)) {
                String response = Jsoup.connect(URL_BTC).ignoreContentType(true).get().body().text();
                JsonObject obj = GSON.fromJson(response, JsonObject.class);
                result.append("Bitcoin       " + obj.get("data").getAsJsonObject().get("last").toString() + " USD\n");
            }
            if (userCurrencies.contains(Currency.ETHEREUM)) {
                String response = Jsoup.connect(URL_ETH).ignoreContentType(true).get().body().text();
                JsonObject obj = GSON.fromJson(response, JsonObject.class);
                result.append("Ethereum " + obj.get("data").getAsJsonObject().get("last").toString() + " USD\n");
            }
        } catch (IOException e) {
            return "";
        }
        return result.toString();
    }
}
