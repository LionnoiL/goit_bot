package ua.dpw.telegrambots.currencybot.messages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.currency.services.CurrencyRateCryptoService;
import ua.dpw.currency.storage.CurrencyRateStorage;
import ua.dpw.users.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageService {
    private static String DELIMITER = "----------------------------------";

    public static String getInformationMessageByUser(User user) {
        if (user == null) {
            return "";
        }

        List<String> messages = new ArrayList<>();
        Message currencyMessage = getCurrencyMessage(user);
        Message cryptoMessage = getCryptoMessage(user);

        messages.add(currencyMessage.isEmpty() ? currencyMessage.getInfo() : currencyMessage.toString());
        messages.add(cryptoMessage.isEmpty() ? cryptoMessage.getInfo() : cryptoMessage.toString());

        return String.join("\n"+DELIMITER+"\n", messages);
    }

    private static Message getCurrencyMessage(User user){
        Message message = new Message();
        Comparator<CurrencyRate> currencyRateComparator = Comparator.comparing(
                CurrencyRate::getBank).thenComparing(CurrencyRate::getCurrency)
            .thenComparing(CurrencyRate::getCurrency);

        List<CurrencyRate> rates = CurrencyRateStorage.getCacheRates(user.getBank());
        if (rates.isEmpty()) {
            message.setInfo(String.format(
                user.getLanguage().get("MESSAGE_SERVICE_BANK_RATES_NOT_FOUND"),
                user.getLanguage().get(user.getBank().toString())));
            return message;
        }

        List<Currency> userCurrencies = user.getCurrencies();
        List<Currency> userCurrenciesWithoutCrypto = userCurrencies.stream()
            .filter(currency -> currency.getId() != 0)
            .collect(Collectors.toList());

        if (userCurrenciesWithoutCrypto.size()==0){
            message.setInfo(user.getLanguage().get("MESSAGE_CURRENCY_NOT_SELECTED"));
            return message;
        }

        message.setHeader(String.format(user.getLanguage().get("MESSAGE_SERVICE_HEADER"),
            user.getLanguage().get(user.getBank().toString())));
        message.setHeaderDelimiter("\n"+DELIMITER);

        message.setBody(rates.stream()
            .filter(rate -> user.getCurrencies().contains(rate.getCurrency()))
            .sorted(currencyRateComparator)
            .map(rate -> formatRatesRow(user, rate))
            .collect(Collectors.toList())
            .toString()
            .replaceAll("(\\[)|(])|(,\\D)", ""));

        return message;
    }

    private static Message getCryptoMessage(User user){
        Message message = new Message();

        String cryptoInfo = new CurrencyRateCryptoService().cryptoInfo(user);
        if (!cryptoInfo.isEmpty()) {
            message.setBody("\n" + cryptoInfo);
        }

        return message;
    }

    private static String formatRatesRow(User user, CurrencyRate rate) {
        String messageBodyRow = user.getLanguage().get("MESSAGE_SERVICE_BODY_ROW");
        String format = "%." + user.getSymbolsAfterComma() + "f";
        return String.format(messageBodyRow, rate.getCurrency(),
            String.format(format, rate.getBuyingRate()),
            String.format(format, rate.getSellingRate()));
    }

    public static String getHelpInformation(User user){
       StringBuilder sb = new StringBuilder();
       sb.append(user.getLanguage().get("HELP_MESSAGE"));
       return sb.toString();
    }
}