package org.example.telegrambots.currency.menus;

import java.util.ArrayList;
import java.util.List;
import org.example.telegrambots.bot.menus.TelegramMenu;
import org.example.telegrambots.currency.commands.Commands;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class ChoiceNumberSimbolsMenu implements TelegramMenu {

  public InlineKeyboardMarkup createMenu() {
    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

    List<InlineKeyboardButton> row1 = new ArrayList<>();
    InlineKeyboardButton button2 = new InlineKeyboardButton(Commands.NUMBERS_2.getButtonText());
    button2.setCallbackData(Commands.NUMBERS_2.toString());
    row1.add(button2);

    List<InlineKeyboardButton> row2 = new ArrayList<>();
    InlineKeyboardButton button3 = new InlineKeyboardButton(Commands.NUMBERS_3.getButtonText());
    button3.setCallbackData(Commands.NUMBERS_3.toString());
    row2.add(button3);

    List<InlineKeyboardButton> row3 = new ArrayList<>();
    InlineKeyboardButton button4 = new InlineKeyboardButton(Commands.NUMBERS_4.getButtonText());
    button4.setCallbackData(Commands.NUMBERS_4.toString());
    row3.add(button4);

    rowList.add(row1);
    rowList.add(row2);
    rowList.add(row3);
    inlineKeyboardMarkup.setKeyboard(rowList);

    return inlineKeyboardMarkup;
  }
}
