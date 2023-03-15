package ua.dpw.telegrambots.currencybot.messages;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ua.dpw.AppLauncher;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.currency.storage.CurrencyRateStorage;
import ua.dpw.users.User;
import ua.dpw.users.UserService;
import ua.dpw.utils.JsonConverter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageService {

    public static String getInformationMessageByUserId(long userId) {
        int decimalPrecision = AppLauncher.APPLICATION_PROPERTIES.getDecimalPrecision();
        Bank bank = AppLauncher.APPLICATION_PROPERTIES.getBank();
        List<Currency> currencyList = List.of(AppLauncher.APPLICATION_PROPERTIES.getCurrency());
        UserService userService = new UserService();
        User user = userService.getUserById(userId);
        if (user != null) {
            decimalPrecision = user.getSymbolsAfterComma();
            bank = user.getBank();
            currencyList = user.getCurrencies();
        } else {
            return "";
        }
        return getFormattedRateBotMessage(decimalPrecision, bank, currencyList, user);
    }

    public static String getFormattedRateBotMessage(int decimalPrecision, Bank bank,
        List<Currency> currencies, User user) {
        String messageBankRatesNotFound = user.getLanguage()
            .get("MESSAGE_SERVICE_BANK_RATES_NOT_FOUND");
        String messageCurrencyNotSelected = "Щоб отримати інформацію про курс валют, будь ласка, оберіть в налаштуваннях валюту, що вас цікавить.";
        String messageHeader = String.format(user.getLanguage().get("MESSAGE_SERVICE_HEADER"),
            user.getLanguage().get(bank.toString()));
        String messageBodyRow = user.getLanguage().get("MESSAGE_SERVICE_BODY_ROW");
        String rateFormat = "%." + decimalPrecision + "f";
        String ratesJson = CurrencyRateStorage.getCacheRatesJson(bank);
        if (ratesJson.isEmpty()) {
            return String.format(messageBankRatesNotFound, bank);
        }
        List<CurrencyRate> rates = JsonConverter.convertJsonStringToList(ratesJson,
            CurrencyRate.class);
        Comparator<CurrencyRate> currencyRateComparator = Comparator.comparing(
                CurrencyRate::getBank).thenComparing(CurrencyRate::getCurrency)
            .thenComparing(CurrencyRate::getCurrency);
        String messageBody = rates.stream()
            .filter(rate -> currencies.contains(rate.getCurrency()))
            .sorted(currencyRateComparator)
            .map(rate -> String.format(messageBodyRow,
                rate.getCurrency(),
                String.format(rateFormat, rate.getBuyingRate()),
                String.format(rateFormat, rate.getSellingRate())))
            .collect(Collectors.toList())
            .toString().replaceAll("(\\[)|(])|(,\\D)", "");
        return messageBody.isEmpty() ? messageCurrencyNotSelected : messageHeader + messageBody;
    }
}