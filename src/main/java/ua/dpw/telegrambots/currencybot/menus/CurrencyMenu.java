package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.properties.ApplicationProperties.MARK_EMOJI;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class CurrencyMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        List<Currency> currencies = userMessage.getUser().getCurrencies();

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();

        InlineKeyboardButton buttonUsd = new InlineKeyboardButton(
            (currencies.contains(Currency.USD) ? MARK_EMOJI : "") + userMessage.getUser()
                .getLanguage().get("CURRENCY_USD"));
        buttonUsd.setCallbackData(Commands.CURRENCY_USD.toString());

        InlineKeyboardButton buttonEur = new InlineKeyboardButton(
            (currencies.contains(Currency.EUR) ? MARK_EMOJI : "") + userMessage.getUser()
                .getLanguage().get("CURRENCY_EUR"));
        buttonEur.setCallbackData(Commands.CURRENCY_EUR.toString());

        InlineKeyboardButton buttonBack = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("BACK"));
        buttonBack.setCallbackData(Commands.MAIN_OPTIONS.toString());

        row1.add(buttonUsd);
        row2.add(buttonEur);
        row3.add(buttonBack);

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
