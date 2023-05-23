package ua.dpw.telegrambots.currencybot.menus;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.telegrambots.bot.menus.MenuUtils;
import ua.dpw.telegrambots.bot.menus.TelegramMenu;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class OptionsMenu implements TelegramMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        addRow1(rowList, userMessage);
        addRow2(rowList, userMessage);
        addRow3(rowList, userMessage);
        addRow4(rowList, userMessage);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    private void addRow1(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String buttonText = userMessage.getUser().getTranslate("OPTIONS_CURRENCY");
        rowList.add(MenuUtils.createMenuRow(buttonText, Commands.OPTIONS_CURRENCY.toString()));
    }

    private void addRow2(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(MenuUtils.createButton(userMessage.getUser().getTranslate("OPTIONS_BANK"),
            Commands.OPTIONS_BANK.toString()));
        row.add(MenuUtils.createButton(
            userMessage.getUser().getTranslate("OPTIONS_NUMBER_SYMBOL_AFTER_COMMA"),
            Commands.OPTIONS_NUMBER_SYMBOL_AFTER_COMMA.toString()));
        rowList.add(row);
    }

    private void addRow3(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(
            MenuUtils.createButton(userMessage.getUser().getTranslate("OPTIONS_NOTIFICATIONS"),
                Commands.OPTIONS_NOTIFICATIONS.toString()));
        row.add(MenuUtils.createButton(userMessage.getUser().getTranslate("OPTIONS_LANGUAGE"),
            Commands.OPTIONS_LANGUAGE.toString()));
        rowList.add(row);
    }

    private void addRow4(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String buttonText = userMessage.getUser().getTranslate("BACK");
        rowList.add(MenuUtils.createMenuRow(buttonText, Commands.MAIN_MENU.toString()));
    }
}
