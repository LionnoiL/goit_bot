package ua.dpw.telegrambots.currencybot.messages;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.currency.storage.CurrencyRateStorage;
import ua.dpw.users.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageService {
    public static String getInformationMessageByUser(User user) {
        if (user == null) {
            return "";
        }
        String messageBankRatesNotFound = String.format(user.getLanguage().get("MESSAGE_SERVICE_BANK_RATES_NOT_FOUND"), user.getLanguage().get(user.getBank().toString()));
        String messageCurrencyNotSelected = user.getLanguage().get("MESSAGE_CURRENCY_NOT_SELECTED");
        String messageHeader = String.format(user.getLanguage().get("MESSAGE_SERVICE_HEADER"), user.getLanguage().get(user.getBank().toString()));
        List<CurrencyRate> rates = CurrencyRateStorage.getCacheRates(user.getBank());
        if (rates.isEmpty()) {
            return messageBankRatesNotFound;
        }
        String messageBody = rates.stream()
                .filter(rate -> user.getCurrencies().contains(rate.getCurrency()))
                .map(rate -> formatRatesRow(user, rate))
                .collect(Collectors.toList())
                .toString()
                .replaceAll("(\\[)|(])|(,\\D)", "");
        return messageBody.isEmpty() ? messageCurrencyNotSelected : messageHeader + messageBody;
    }

    private static String formatRatesRow(User user, CurrencyRate rate) {
        String messageBodyRow = user.getLanguage().get("MESSAGE_SERVICE_BODY_ROW");
        String format = "%." + user.getSymbolsAfterComma() + "f";
        return String.format(messageBodyRow, rate.getCurrency(), String.format(format, rate.getBuyingRate()), String.format(format, rate.getSellingRate()));
    }
}