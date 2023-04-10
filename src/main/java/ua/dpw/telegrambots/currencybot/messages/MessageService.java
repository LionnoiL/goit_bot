package ua.dpw.telegrambots.currencybot.messages;

import static ua.dpw.database.Service.RATES_SERVICE;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.currency.rates.CurrencyRate;
import ua.dpw.currency.services.CurrencyRateCryptoService;
import ua.dpw.telegrambots.bot.services.Emoji;
import ua.dpw.users.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageService {

    private static final String DELIMITER = "----------------------------------";

    public static String getInformationMessageByUser(User user, boolean rateWithDelta) {
        if (user == null) {
            return "";
        }

        List<String> messages = new ArrayList<>();
        Message currencyMessage = getCurrencyMessage(user, rateWithDelta);
        Message cryptoMessage = getCryptoMessage(user);

        messages.add(
            currencyMessage.isEmpty() ? currencyMessage.getInfo() : currencyMessage.toString());
        messages.add(cryptoMessage.isEmpty() ? cryptoMessage.getInfo() : cryptoMessage.toString());

        return String.join("\n" + DELIMITER + "\n", messages);
    }

    private static Message getCurrencyMessage(User user, boolean rateWithDelta) {
        Message message = new Message();
        List<CurrencyRate> rates = RATES_SERVICE.getLastRatesByUser(user);
        if (rates.isEmpty()) {
            message.setInfo(String.format(
                user.getTranslate("MESSAGE_SERVICE_BANK_RATES_NOT_FOUND"),
                user.getTranslate(user.getBank().toString())));
            return message;
        }

        List<Currency> userCurrencies = user.getCurrencies();
        List<Currency> userCurrenciesWithoutCrypto = userCurrencies.stream()
            .filter(currency -> currency.getCode() != 0)
            .toList();

        if (userCurrenciesWithoutCrypto.isEmpty()) {
            message.setInfo(user.getTranslate("MESSAGE_CURRENCY_NOT_SELECTED"));
            return message;
        }

        message.setHeader(String.format(user.getTranslate("MESSAGE_SERVICE_HEADER"),
            user.getTranslate(user.getBank().toString())));
        message.setHeaderDelimiter("\n" + DELIMITER);

        message.setBody(rates.stream()
            .filter(rate -> user.getCurrencies().contains(rate.getCurrency()))
            .map(rate -> formatRatesRow(user, rate, rateWithDelta))
            .toList()
            .toString()
            .replaceAll("(\\[)|(])|(,\\D)", ""));

        return message;
    }

    private static Message getCryptoMessage(User user) {
        Message message = new Message();

        String cryptoInfo = new CurrencyRateCryptoService().cryptoInfo(user);
        if (!cryptoInfo.isEmpty()) {
            message.setBody("\n" + cryptoInfo);
        }

        return message;
    }

    private static String formatRatesRow(User user, CurrencyRate rate, boolean rateWithDelta) {
        String messageBodyRow = user.getTranslate("MESSAGE_SERVICE_BODY_ROW");
        String format = "%." + user.getSymbolsAfterComma() + "f";
        double amountBuyChange = 0;
        double amountSaleChange = 0;

        if (rate.getAmountBuyChange() != null) {
            amountBuyChange = rate.getAmountBuyChange().doubleValue();
        }

        if (rate.getAmountSaleChange() != null) {
            amountSaleChange = rate.getAmountSaleChange().doubleValue();
        }

        String buyChange = "";
        String saleChange = "";

        if (rateWithDelta) {
            if (amountBuyChange != 0) {
                if (amountBuyChange > 0) {
                    buyChange =
                        "\t" + Emoji.RED_TRIANGLE_UP + String.format(format, amountBuyChange);
                } else {
                    buyChange =
                        "\t" + Emoji.RED_TRIANGLE_DOWN + String.format(format, -amountBuyChange);
                }
            }

            if (amountSaleChange != 0) {
                if (amountSaleChange > 0) {
                    saleChange =
                        "\t" + Emoji.RED_TRIANGLE_UP + String.format(format, amountSaleChange);
                } else {
                    saleChange =
                        "\t" + Emoji.RED_TRIANGLE_DOWN + String.format(format, -amountSaleChange);
                }
            }
        }

        return String.format(messageBodyRow, rate.getCurrency(),
            String.format(format, rate.getBuyingRate()) + buyChange,
            String.format(format, rate.getSellingRate()) + saleChange);
    }

    public static String getHelpInformation(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append(user.getTranslate("HELP_MESSAGE"));
        return sb.toString();
    }
}
