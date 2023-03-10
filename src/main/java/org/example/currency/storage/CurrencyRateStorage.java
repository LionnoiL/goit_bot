package org.example.currency.storage;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.currency.bank.Bank;
import org.example.currency.rates.CurrencyRate;
import org.example.properties.ApplicationProperties;
import org.example.utils.FilesUtils;

public class CurrencyRateStorage {

    private static final Logger LOG = LogManager.getLogger(CurrencyRateStorage.class);

    public static void saveRateToCache(List<CurrencyRate> currencyRates) {
        if (!currencyRates.isEmpty()) {
            Bank bank = currencyRates.get(0).getBank();
            String filePath = ApplicationProperties.CACHE_PATH + bank + ".cache";
            FilesUtils.saveTextFile(filePath, new Gson().toJson(currencyRates));
        }
    }

    public static String getCacheRatesJson(Bank bank) {
        String res = "";
        Path filePath = Path.of(ApplicationProperties.CACHE_PATH + bank + ".cache");
        if (!Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)) {
            return res;
        }
        try {
            res = Files.readString(filePath);
        } catch (IOException e) {
            LOG.warn("Error read cache file " + ApplicationProperties.CACHE_PATH + bank + ".cache");
        }
        return res;
    }
}