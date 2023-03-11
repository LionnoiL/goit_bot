package org.example.telegrambots.currency.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.example.language.LanguageSwitcher;
import org.example.telegrambots.bot.menus.TelegramMenu;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class ChoiceNumberSymbolMenu implements TelegramMenu {

  public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
    int symbolsAfterComma = userMessage.getUser().getSymbolsAfterComma();
    String markEmoji = "✔";

    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

    List<InlineKeyboardButton> row1 = new ArrayList<>();
    InlineKeyboardButton button2 = new InlineKeyboardButton((symbolsAfterComma==2 ?  markEmoji: "") + userMessage.getUser().getLanguage().get("NUMBERS_2"));
    button2.setCallbackData(Commands.NUMBERS_2.toString());
    row1.add(button2);

    List<InlineKeyboardButton> row2 = new ArrayList<>();
    InlineKeyboardButton button3 = new InlineKeyboardButton((symbolsAfterComma==3 ?  markEmoji: "") + userMessage.getUser().getLanguage().get("NUMBERS_3"));
    button3.setCallbackData(Commands.NUMBERS_3.toString());
    row2.add(button3);

    List<InlineKeyboardButton> row3 = new ArrayList<>();
    InlineKeyboardButton button4 = new InlineKeyboardButton((symbolsAfterComma==4 ?  markEmoji: "") + userMessage.getUser().getLanguage().get("NUMBERS_4"));
    button4.setCallbackData(Commands.NUMBERS_4.toString());
    row3.add(button4);

    List<InlineKeyboardButton> row4 = new ArrayList<>();
    InlineKeyboardButton buttonBack = new InlineKeyboardButton(userMessage.getUser().getLanguage().get("BACK"));
    buttonBack.setCallbackData(Commands.MAIN_OPTIONS.toString());
    row4.add(buttonBack);

    rowList.add(row1);
    rowList.add(row2);
    rowList.add(row3);
    rowList.add(row4);
    inlineKeyboardMarkup.setKeyboard(rowList);

    return inlineKeyboardMarkup;
  }
}
