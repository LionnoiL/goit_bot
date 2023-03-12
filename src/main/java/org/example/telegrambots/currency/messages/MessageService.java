package org.example.telegrambots.currency.messages;

import static org.example.AppLauncher.APPLICATION_PROPERTIES;

import org.example.currency.bank.Bank;
import org.example.currency.currencies.Currency;
import org.example.currency.storage.CurrencyRateStorage;
import org.example.users.User;
import org.example.users.UserService;

import java.util.List;

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

        return CurrencyRateStorage.getFormattedRateBotMessage(decimalPrecision, bank, currencyList);
    }
}