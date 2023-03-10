package org.example.telegrambots.currency.menus;

import org.example.telegrambots.bot.menus.TelegramMenu;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class BankMenu implements TelegramMenu {
    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        String bankName = String.valueOf(userMessage.getUser().getBank());
        String markEmoji = "✔";

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button2 = new InlineKeyboardButton((bankName.equals("Privatbank") ?  markEmoji: "") + Commands.BANK_PRIVATBANK.getButtonText());
        button2.setCallbackData(Commands.BANK_PRIVATBANK.toString());
        row1.add(button2);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton button3 = new InlineKeyboardButton((bankName.equals("Monobank") ?  markEmoji: "") + Commands.BANK_MONOBANK.getButtonText());
        button3.setCallbackData(Commands.BANK_MONOBANK.toString());
        row2.add(button3);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton button4 = new InlineKeyboardButton((bankName.equals("NBU") ?  markEmoji: "") + Commands.BANK_NBU.getButtonText());
        button4.setCallbackData(Commands.BANK_NBU.toString());
        row3.add(button4);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton buttonBack = new InlineKeyboardButton(Commands.BACK.getButtonText());
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
