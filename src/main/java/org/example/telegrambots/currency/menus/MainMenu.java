package org.example.telegrambots.currency.menus;

import java.util.ArrayList;
import java.util.List;
import org.example.telegrambots.bot.menus.TelegramMenu;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class MainMenu implements TelegramMenu {

  public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

    List<InlineKeyboardButton> row1 = new ArrayList<>();
    InlineKeyboardButton getInfoButton = new InlineKeyboardButton(Commands.MAIN_GET_INFO.getButtonText());
    getInfoButton.setCallbackData(Commands.MAIN_GET_INFO.toString());
    row1.add(getInfoButton);

    List<InlineKeyboardButton> row2 = new ArrayList<>();
    InlineKeyboardButton getOptionsButton = new InlineKeyboardButton(Commands.MAIN_OPTIONS.getButtonText());
    getOptionsButton.setCallbackData(Commands.MAIN_OPTIONS.toString());
    row2.add(getOptionsButton);

    rowList.add(row1);
    rowList.add(row2);
    inlineKeyboardMarkup.setKeyboard(rowList);

    return inlineKeyboardMarkup;
  }
}
