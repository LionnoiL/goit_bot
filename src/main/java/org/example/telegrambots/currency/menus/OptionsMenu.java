package org.example.telegrambots.currency.menus;

import java.util.ArrayList;
import java.util.List;
import org.example.telegrambots.bot.menus.TelegramMenu;
import org.example.telegrambots.currency.commands.Commands;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class OptionsMenu implements TelegramMenu {

  public InlineKeyboardMarkup createMenu() {
    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

    List<InlineKeyboardButton> row1 = new ArrayList<>();
    InlineKeyboardButton optionsNumberSimbolsButton = new InlineKeyboardButton(Commands.OPTIONS_NUMBER_SIMBOLS_AFTER_COMMA.getButtonText());
    optionsNumberSimbolsButton.setCallbackData(Commands.OPTIONS_NUMBER_SIMBOLS_AFTER_COMMA.toString());
    row1.add(optionsNumberSimbolsButton);

    List<InlineKeyboardButton> row2 = new ArrayList<>();
    InlineKeyboardButton optionsBankButton = new InlineKeyboardButton(Commands.OPTIONS_BANK.getButtonText());
    optionsBankButton.setCallbackData(Commands.OPTIONS_BANK.toString());
    row2.add(optionsBankButton);

    List<InlineKeyboardButton> row3 = new ArrayList<>();
    InlineKeyboardButton optionsCurrencyButton = new InlineKeyboardButton(Commands.OPTIONS_CURRENCY.getButtonText());
    optionsCurrencyButton.setCallbackData(Commands.OPTIONS_BANK.toString());
    row3.add(optionsCurrencyButton);

    rowList.add(row1);
    rowList.add(row2);
    rowList.add(row3);
    inlineKeyboardMarkup.setKeyboard(rowList);

    return inlineKeyboardMarkup;
  }
}
