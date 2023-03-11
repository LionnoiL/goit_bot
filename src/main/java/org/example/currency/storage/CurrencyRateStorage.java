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
    public static void saveRateToCache(Bank bank, List<CurrencyRate> currencyRates) {
        String filePath = ApplicationProperties.CACHE_PATH + bank + "Rate.json";
        FilesUtils.saveTextFile(filePath, new Gson().toJson(currencyRates));
    }
    public static String getCacheRatesJson(Bank bank) {
        String res = "";
        Path filePath = Path.of(ApplicationProperties.CACHE_PATH + bank + "_Rate.json");
        if (!Files.exists(filePath)) {
            return res;
        }
        try {
            res = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}