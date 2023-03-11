package org.example.currency.storage;

import com.google.gson.Gson;
import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import org.example.currency.rates.CurrencyRate;
import org.example.properties.ApplicationProperties;
import org.example.utils.FilesUtils;
import org.example.utils.JsonConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyRateStorage {
    public static void saveRateToCache(List<CurrencyRate> currencyRates) {
        if (!currencyRates.isEmpty()) {
            Bank bank = currencyRates.get(0).getBank();
            String filePath = ApplicationProperties.CACHE_PATH + bank + "_Rate.json";
            FilesUtils.saveTextFile(filePath, new Gson().toJson(currencyRates));
        }
    }

    public static String getCacheRatesJson(Bank bank) {
        String res = "";
        Path filePath = Path.of(ApplicationProperties.CACHE_PATH + bank + "_Rate.json");
        if (!Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)) {
            return res;
        }
        try {
            res = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String getFormattedRateBotMessage(int decimalPrecision, Bank bank, List<Currency> currencies) {
        String rateFormat = "%." + decimalPrecision + "f";
        String res = "Курс в " + bank.getUaBankName() + ":";
        String ratesJson = getCacheRatesJson(bank);
        if (ratesJson.isEmpty()) {
            return "Інформація про курси валют по банку " + bank + " відсутня!";
        }
        List<CurrencyRate> rates = JsonConverter.convertJsonStringToList(ratesJson, CurrencyRate.class);
        res += rates.stream()
                .filter(rate -> currencies.contains(rate.getCurrency()))
                .map(rate -> "\n" + rate.getCurrency() + "/UAN:" +
                        "\nКупівля\t" + String.format(rateFormat, rate.getBuyingRate()) +
                        "\nПродаж\t" + String.format(rateFormat, rate.getSellingRate()))
                .collect(Collectors.toList())
                .toString().replaceAll("(\\[)|(\\])", "");
        return res;
    }
}