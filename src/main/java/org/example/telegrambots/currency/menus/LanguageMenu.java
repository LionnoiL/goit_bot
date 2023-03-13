package org.example.telegrambots.currency.menus;

import java.util.ArrayList;
import java.util.List;
import org.example.telegrambots.bot.menus.TelegramMenu;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class LanguageMenu implements TelegramMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {

        String langCode = userMessage.getUser().getLangCode();
        String markEmoji = "✔";

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton uaButton = new InlineKeyboardButton(
            ("uk".equals(langCode) ? markEmoji : "") +
                userMessage.getUser().getLanguage().get("UA_BUTTON"));
        uaButton.setCallbackData(Commands.UA_BUTTON.toString());
        row1.add(uaButton);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton enButton = new InlineKeyboardButton(
            ("en".equals(langCode) ? markEmoji : "") +
                userMessage.getUser().getLanguage().get("EN_BUTTON"));
        enButton.setCallbackData(Commands.EN_BUTTON.toString());
        row2.add(enButton);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton plButton = new InlineKeyboardButton(
            ("pl".equals(langCode) ? markEmoji : "") +
                userMessage.getUser().getLanguage().get("PL_BUTTON"));
        enButton.setCallbackData(Commands.PL_BUTTON.toString());
        row3.add(plButton);

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
