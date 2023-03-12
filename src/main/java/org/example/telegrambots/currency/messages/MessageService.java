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
        //TODO: пропоную в APPLICATION_PROPERTIES переписати сurrency на List

        UserService userService = new UserService();
        User user = userService.getUserById(userId);

        if (user != null) {
            decimalPrecision = user.getSymbolsAfterComma();
            bank = user.getBank();
            currencyList = user.getCurrencies();
        }
        return getFormattedRateBotMessage(decimalPrecision, bank, currencyList);
    }

    public static String getFormattedRateBotMessage(int decimalPrecision, Bank bank, List<Currency> currencies) {
        String messageBankRatesNotFound = "На даний момент інформація про курси валют \"%s\" відсутня. Будь ласка, оберіть  в налаштуваннях інший банк.";
        String messageCurrencyNotSelected = "Щоб отримати інформацію про курс валют, будь ласка, оберіть в налаштуваннях валюту, що вас цікавить.";
        String messageHeader = String.format("Курс в %s:", bank.getUaBankName());
        String messageBodyRow = "\n\n%s/UAN:\nКупівля\t%s\nПродаж\t%s";
        //TODO: налаштувати messageBankRatesNotFound, messageCurrencyNotSelected,  messageHeader, messageBodyRow в залежності від мови
        String rateFormat = "%." + decimalPrecision + "f";
        String ratesJson = getCacheRatesJson(bank);
        if (ratesJson.isEmpty()) {
            return String.format(messageBankRatesNotFound, bank.getUaBankName());
        }
        List<CurrencyRate> rates = JsonConverter.convertJsonStringToList(ratesJson, CurrencyRate.class);
        String messageBody = rates.stream()
                .filter(rate -> currencies.contains(rate.getCurrency()))
                .map(rate -> String.format(messageBodyRow,
                        rate.getCurrency(),
                        String.format(rateFormat, rate.getBuyingRate()),
                        String.format(rateFormat, rate.getSellingRate())))
                .collect(Collectors.toList())
                .toString().replaceAll("(\\[)|(\\])|(,\\D)", "");
        return messageBody.isEmpty() ? messageCurrencyNotSelected : messageHeader + messageBody;
    }
}