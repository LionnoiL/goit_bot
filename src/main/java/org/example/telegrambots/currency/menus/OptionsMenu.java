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
    InlineKeyboardButton optionsNumberSimbolsButton = new InlineKeyboardButton(userMessage.getUser().getLanguage().get("OPTIONS_NUMBER_SYMBOL_AFTER_COMMA"));
    optionsNumberSimbolsButton.setCallbackData(Commands.OPTIONS_NUMBER_SYMBOL_AFTER_COMMA.toString());
    row1.add(optionsNumberSimbolsButton);

    List<InlineKeyboardButton> row2 = new ArrayList<>();
    InlineKeyboardButton optionsBankButton = new InlineKeyboardButton(userMessage.getUser().getLanguage().get("OPTIONS_BANK"));
    optionsBankButton.setCallbackData(Commands.OPTIONS_BANK.toString());
    row2.add(optionsBankButton);

    InlineKeyboardButton optionsCurrencyButton = new InlineKeyboardButton(userMessage.getUser().getLanguage().get("OPTIONS_CURRENCY"));
    optionsCurrencyButton.setCallbackData(Commands.OPTIONS_CURRENCY.toString());
    row2.add(optionsCurrencyButton);

    List<InlineKeyboardButton> row4 = new ArrayList<>();
    InlineKeyboardButton optionsAlertButton = new InlineKeyboardButton(userMessage.getUser().getLanguage().get("OPTIONS_NOTIFICATIONS"));
    optionsAlertButton.setCallbackData(Commands.OPTIONS_NOTIFICATIONS.toString());
    row4.add(optionsAlertButton);

    InlineKeyboardButton optionsLanguageButton = new InlineKeyboardButton(userMessage.getUser().getLanguage().get("OPTIONS_LANGUAGE"));
    optionsLanguageButton.setCallbackData(Commands.OPTIONS_LANGUAGE.toString());
    row4.add(optionsLanguageButton);

    List<InlineKeyboardButton> row6 = new ArrayList<>();
    InlineKeyboardButton buttonBack = new InlineKeyboardButton(userMessage.getUser().getLanguage().get("BACK"));
    buttonBack.setCallbackData(Commands.MAIN_MENU.toString());
    row6.add(buttonBack);

    rowList.add(row1);
    rowList.add(row2);
    //rowList.add(row3);
    rowList.add(row4);
//    rowList.add(row5);
    rowList.add(row6);
    inlineKeyboardMarkup.setKeyboard(rowList);

    return inlineKeyboardMarkup;
  }
}
