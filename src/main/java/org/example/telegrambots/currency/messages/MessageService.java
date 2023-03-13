package org.example.telegrambots.currency.messages;

import static org.example.AppLauncher.APPLICATION_PROPERTIES;
import static org.example.currency.storage.CurrencyRateStorage.getCacheRatesJson;

import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import org.example.currency.rates.CurrencyRate;
import org.example.users.User;
import org.example.users.UserService;
import org.example.utils.JsonConverter;

import java.util.List;
import java.util.stream.Collectors;

public class MessageService {
    public static String getInformationMessageByUserId(long userId) {

        int decimalPrecision = APPLICATION_PROPERTIES.getDecimalPrecision();
        Bank bank = APPLICATION_PROPERTIES.getBank();
        List<Currency> currencyList = List.of(APPLICATION_PROPERTIES.getCurrency());

        UserService userService = new UserService();
        User user = userService.getUserById(userId);

        if (user != null) {
            decimalPrecision = user.getSymbolsAfterComma();
            bank = user.getBank();
            currencyList = user.getCurrencies();
        }

        return getFormattedRateBotMessage(decimalPrecision, bank, currencyList, user);
    }

    public static String getFormattedRateBotMessage(int decimalPrecision, Bank bank, List<Currency> currencies, User user) {

        String rateFormat = "%." + decimalPrecision + "f";
        String messageHeader = String.format(user.getLanguage().get("CURRENCY_TXT"),
                user.getLanguage().get(bank.toString()));
        String messageBodyRow = "\n%s/UAN:\n" + user.getLanguage().get("BUY") +
                "\t%s\n" + user.getLanguage().get("SELL") + "\t%s";

        //TODO: налаштувати messageHeader та messageBodyRow в залежності від мови

        String ratesJson = getCacheRatesJson(bank);

        if (ratesJson.isEmpty()) {
            return user.getLanguage().get("ALLERT_FIRST_PART") + bank + user.getLanguage().get("ALLERT_SECOND_PART");
        //TODO: налаштувати повідомлення в зележності від мови
        }

        List<CurrencyRate> rates = JsonConverter.convertJsonStringToList(ratesJson, CurrencyRate.class);
        String messageBody = rates.stream()
                .filter(rate -> currencies.contains(rate.getCurrency()))
                .map(rate -> String.format(messageBodyRow,
                        rate.getCurrency(),
                        String.format(rateFormat, rate.getBuyingRate()),
                        String.format(rateFormat, rate.getSellingRate())))
                .collect(Collectors.toList())
                .toString().replaceAll("(\\[)|(\\])", "");

        return messageHeader + messageBody;
    }
}