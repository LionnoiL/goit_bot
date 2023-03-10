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
    InlineKeyboardButton optionsNumberSimbolsButton = new InlineKeyboardButton(Commands.OPTIONS_NUMBER_SYMBOL_AFTER_COMMA.getButtonUkrText());
    optionsNumberSimbolsButton.setCallbackData(Commands.OPTIONS_NUMBER_SYMBOL_AFTER_COMMA.toString());
    row1.add(optionsNumberSimbolsButton);

    List<InlineKeyboardButton> row2 = new ArrayList<>();
    InlineKeyboardButton optionsBankButton = new InlineKeyboardButton(Commands.OPTIONS_BANK.getButtonUkrText());
    optionsBankButton.setCallbackData(Commands.OPTIONS_BANK.toString());
    row2.add(optionsBankButton);

    List<InlineKeyboardButton> row3 = new ArrayList<>();
    InlineKeyboardButton optionsCurrencyButton = new InlineKeyboardButton(Commands.OPTIONS_CURRENCY.getButtonUkrText());
    optionsCurrencyButton.setCallbackData(Commands.OPTIONS_CURRENCY.toString());
    row3.add(optionsCurrencyButton);

    List<InlineKeyboardButton> row4 = new ArrayList<>();
    InlineKeyboardButton buttonBack = new InlineKeyboardButton(Commands.BACK.getButtonUkrText());
    buttonBack.setCallbackData(Commands.MAIN_MENU.toString());
    row4.add(buttonBack);

    rowList.add(row1);
    rowList.add(row2);
    rowList.add(row3);
    rowList.add(row4);
    inlineKeyboardMarkup.setKeyboard(rowList);

    return inlineKeyboardMarkup;
  }
}
