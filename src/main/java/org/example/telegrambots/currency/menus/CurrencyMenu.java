package org.example.telegrambots.currency.menus;

import org.example.currency.currencies.Currency;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class CurrencyMenu {
    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        List<Currency> currencies = userMessage.getUser().getCurrencies();
        String markEmoji = "✔";

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton buttonUsd = new InlineKeyboardButton((currencies.contains(Currency.USD) ? markEmoji : "") + userMessage.getUser().getLanguage().get("CURRENCY_USD"));
        buttonUsd.setCallbackData(Commands.CURRENCY_USD.toString());
        row1.add(buttonUsd);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton buttonEur = new InlineKeyboardButton((currencies.contains(Currency.EUR) ? markEmoji : "") + userMessage.getUser().getLanguage().get("CURRENCY_EUR"));
        buttonEur.setCallbackData(Commands.CURRENCY_EUR.toString());
        row2.add(buttonEur);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton buttonBack = new InlineKeyboardButton(userMessage.getUser().getLanguage().get("BACK"));
        buttonBack.setCallbackData(Commands.MAIN_OPTIONS.toString());
        row3.add(buttonBack);

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
