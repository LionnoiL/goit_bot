package org.example.telegrambots.currency.messages;

import static org.example.AppLauncher.APPLICATION_PROPERTIES;

import java.util.List;
import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import org.example.currency.rates.CurrencyRate;
import org.example.currency.storage.CurrencyRateStorage;
import org.example.users.User;
import org.example.users.UserService;
import org.example.utils.JsonConverter;

public class MessageService {

    public static String getInformationMessageByUserId(long userId) {

        int decimalPrecision = APPLICATION_PROPERTIES.getDecimalPrecision();
        Bank bank = APPLICATION_PROPERTIES.getBank();
        List<Currency> currencyList = List.of(APPLICATION_PROPERTIES.getCurrency());

        User user = new UserService().getUserById(userId);

        if (user != null) {
            decimalPrecision = user.getSymbolsAfterComma();
            bank = user.getBank();
            currencyList = List.of(user.getCurrency());
        }

        String rateFormat = "%." + decimalPrecision + "f";
        String res = user.getTranslation("Rate in ") + user.getTranslation(bank.getName()) + ":";
        String ratesJson = CurrencyRateStorage.getCacheRatesJson(bank);

        if (ratesJson.isEmpty()) {
            return user.getTranslation("Information about exchange rates by bank")
                + user.getTranslation(bank.getName()) + user.getTranslation(" missing!");
        }
        List<CurrencyRate> rates = JsonConverter.convertJsonStringToList(ratesJson,
            CurrencyRate.class);
        for (CurrencyRate rate : rates) {
            if (currencyList.contains(rate.getCurrency())) {
                res += "\n" + rate.getCurrency() + "/UAN:";
                res += "\n" + user.getTranslation("Purchase") + "\t" + String.format(rateFormat,
                    rate.getBuyingRate());
                res += "\n" + user.getTranslation("Selling") + "\t" + String.format(rateFormat,
                    rate.getSellingRate());
            }
        }
        res = res.replaceAll("(\\[)|(\\])", "");
        return res;
    }
}