package org.example.currency.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.currency.currencies.Currency;
import org.example.currency.bank.Bank;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyRateStorage {

    // метод зберігає завантажений курс в кеш
    public static void saveRateToCache(Bank bank, List<CurrencyRate> currencyRates) {

        String filePath = "src\\main\\resources\\cache\\" + bank + "Rate.json";

        try {
            Gson gson = new Gson();

            FileWriter fileWriter = new FileWriter(filePath);
            gson.toJson(currencyRates, fileWriter);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // метод повертає json з курсами банку із кешу
    public static String getCacheRatesJson(Bank bank) {

        String res = "";
        Path filePath = Path.of("src\\main\\resources\\cache\\" + bank + "Rate.json");

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

    // метод повертає відформатоване повідомлення з курсом валют
    public static String getFormattedRateBotMessage(int decimalPrecision, Bank bank, List<Currency> currencies) {

        String rateFormat = "%." + decimalPrecision + "f";

        String res = "Курс в " + bank + ":";

        String ratesJson = getCacheRatesJson(bank);

        if (ratesJson.isEmpty()) {
            return "Інформація про курси валют по банку " + bank + " відсутня!";
        }

        Gson gson = new Gson();
        Type type = TypeToken.getParameterized(ArrayList.class, CurrencyRate.class).getType();
        List<CurrencyRate> rates = gson.fromJson(ratesJson, type);

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
