package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.telegrambots.bot.services.Emoji.INFORMATION_SOURCE;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.telegrambots.bot.menus.MenuUtils;
import ua.dpw.telegrambots.bot.menus.TelegramMenu;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class MainMenu implements TelegramMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        addRow1(rowList, userMessage);
        addRow2(rowList, userMessage);
        addRow3(rowList, userMessage);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    private void addRow1(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String buttonText = userMessage.getUser().getTranslate("MAIN_GET_INFO");
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(buttonText,
            Commands.MAIN_GET_INFO.toString());
        rowList.add(menuRow);
    }

    private void addRow2(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String buttonText = userMessage.getUser().getTranslate("MAIN_OPTIONS");
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(buttonText,
            Commands.MAIN_OPTIONS.toString());
        rowList.add(menuRow);
    }

    private void addRow3(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String buttonText =
            INFORMATION_SOURCE.toString() + userMessage.getUser().getTranslate("HELP");
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(buttonText,
            Commands.HELP.toString());
        rowList.add(menuRow);
    }
}
