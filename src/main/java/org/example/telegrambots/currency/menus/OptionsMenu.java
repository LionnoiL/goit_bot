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
    InlineKeyboardButton optionsNumberSimbolsButton = new InlineKeyboardButton(Commands.OPTIONS_NUMBER_SYMBOL_AFTER_COMMA.getButtonText());
    optionsNumberSimbolsButton.setCallbackData(Commands.OPTIONS_NUMBER_SYMBOL_AFTER_COMMA.toString());
    row1.add(optionsNumberSimbolsButton);

    List<InlineKeyboardButton> row2 = new ArrayList<>();
    InlineKeyboardButton optionsBankButton = new InlineKeyboardButton(Commands.OPTIONS_BANK.getButtonText());
    optionsBankButton.setCallbackData(Commands.OPTIONS_BANK.toString());
    row2.add(optionsBankButton);

    List<InlineKeyboardButton> row3 = new ArrayList<>();
    InlineKeyboardButton optionsCurrencyButton = new InlineKeyboardButton(Commands.OPTIONS_CURRENCY.getButtonText());
    optionsCurrencyButton.setCallbackData(Commands.OPTIONS_CURRENCY.toString());
    row3.add(optionsCurrencyButton);

    List<InlineKeyboardButton> row4 = new ArrayList<>();
    InlineKeyboardButton optionsAlertButton = new InlineKeyboardButton(Commands.OPTIONS_NOTIFICATIONS.getButtonText());
    optionsAlertButton.setCallbackData(Commands.OPTIONS_NOTIFICATIONS.toString());
    row4.add(optionsAlertButton);

    List<InlineKeyboardButton> row5 = new ArrayList<>();
    InlineKeyboardButton buttonBack = new InlineKeyboardButton(Commands.BACK.getButtonText());
    buttonBack.setCallbackData(Commands.MAIN_MENU.toString());
    row5.add(buttonBack);

    rowList.add(row1);
    rowList.add(row2);
    rowList.add(row3);
    rowList.add(row4);
    rowList.add(row5);
    inlineKeyboardMarkup.setKeyboard(rowList);

    return inlineKeyboardMarkup;
  }
}
