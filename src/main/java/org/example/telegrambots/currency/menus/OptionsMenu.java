package org.example.telegrambots.currency.menus;

import java.util.ArrayList;
import java.util.List;
import org.example.telegrambots.bot.menus.TelegramMenu;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class OptionsMenu implements TelegramMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();

        InlineKeyboardButton optionsNumberSimbolsButton = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("OPTIONS_NUMBER_SYMBOL_AFTER_COMMA"));
        optionsNumberSimbolsButton.setCallbackData(
            Commands.OPTIONS_NUMBER_SYMBOL_AFTER_COMMA.toString());

        InlineKeyboardButton optionsBankButton = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("OPTIONS_BANK"));
        optionsBankButton.setCallbackData(Commands.OPTIONS_BANK.toString());

        InlineKeyboardButton optionsCurrencyButton = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("OPTIONS_CURRENCY"));
        optionsCurrencyButton.setCallbackData(Commands.OPTIONS_CURRENCY.toString());

        InlineKeyboardButton optionsAlertButton = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("OPTIONS_NOTIFICATIONS"));
        optionsAlertButton.setCallbackData(Commands.OPTIONS_NOTIFICATIONS.toString());

        InlineKeyboardButton optionsLanguageButton = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("OPTIONS_LANGUAGE"));
        optionsLanguageButton.setCallbackData(Commands.OPTIONS_LANGUAGE.toString());

        InlineKeyboardButton buttonBack = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("BACK"));
        buttonBack.setCallbackData(Commands.MAIN_MENU.toString());

        row1.add(optionsCurrencyButton);
        row2.add(optionsBankButton);
        row2.add(optionsNumberSimbolsButton);
        row3.add(optionsAlertButton);
        row3.add(optionsLanguageButton);
        row4.add(buttonBack);

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
