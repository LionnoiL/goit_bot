package ua.dpw.currency.storage;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.properties.ApplicationProperties;
import ua.dpw.utils.FilesUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
        String result = "";
        Path filePath = Path.of(ApplicationProperties.CACHE_PATH + bank + ".cache");
        if (!Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)) {
            return result;
        }
        try {
            result = Files.readString(filePath);
        } catch (IOException e) {
            LOG.warn("Error read cache file {}{}.cache", ApplicationProperties.CACHE_PATH, bank);
        }
        return result;
    }
}