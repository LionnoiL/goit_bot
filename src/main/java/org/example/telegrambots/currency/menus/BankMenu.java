package org.example.telegrambots.currency.menus;

import org.example.currency.bank.Bank;
import org.example.telegrambots.bot.menus.TelegramMenu;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class BankMenu implements TelegramMenu {
    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        Bank bank = userMessage.getUser().getBank();
        String markEmoji = "✔";

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton buttonPrivatbank = new InlineKeyboardButton((bank.equals(Commands.BANK_PRIVATBANK) ?  markEmoji: "") + Commands.BANK_PRIVATBANK.getButtonText());
        buttonPrivatbank.setCallbackData(Commands.BANK_PRIVATBANK.toString());
        row1.add(buttonPrivatbank);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton buttonMonobank = new InlineKeyboardButton((bank.equals(Commands.BANK_MONOBANK) ?  markEmoji: "") + Commands.BANK_MONOBANK.getButtonText());
        buttonMonobank.setCallbackData(Commands.BANK_MONOBANK.toString());
        row2.add(buttonMonobank);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton buttonNbu = new InlineKeyboardButton((bank.equals(Commands.BANK_NBU) ?  markEmoji: "") + Commands.BANK_NBU.getButtonText());
        buttonNbu.setCallbackData(Commands.BANK_NBU.toString());
        row3.add(buttonNbu);

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
