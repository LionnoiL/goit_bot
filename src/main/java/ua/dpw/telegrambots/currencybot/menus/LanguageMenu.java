package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.properties.ApplicationProperties.MARK_EMOJI;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.telegrambots.bot.menus.MenuUtils;
import ua.dpw.telegrambots.bot.menus.TelegramMenu;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class LanguageMenu implements TelegramMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        addRow1(rowList, userMessage);
        addRow2(rowList, userMessage);
        addRow3(rowList, userMessage);
        addRow4(rowList, userMessage);

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    private void addRow1(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String langCode = userMessage.getUser().getLangCode();
        String emoji = "uk".equals(langCode) ? MARK_EMOJI : "";
        String buttonText = emoji + userMessage.getUser().getLanguage().get("UA_BUTTON");
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(buttonText,
            Commands.UA_BUTTON.toString());
        rowList.add(menuRow);
    }

    private void addRow2(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String langCode = userMessage.getUser().getLangCode();
        String emoji = "en".equals(langCode) ? MARK_EMOJI : "";
        String buttonText = emoji + userMessage.getUser().getLanguage().get("EN_BUTTON");
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(buttonText,
            Commands.EN_BUTTON.toString());
        rowList.add(menuRow);
    }

    private void addRow3(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String langCode = userMessage.getUser().getLangCode();
        String emoji = "pl".equals(langCode) ? MARK_EMOJI : "";
        String buttonText = emoji + userMessage.getUser().getLanguage().get("PL_BUTTON");
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(buttonText,
            Commands.PL_BUTTON.toString());
        rowList.add(menuRow);
    }

    private void addRow4(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String buttonText = userMessage.getUser().getLanguage().get("BACK");
        rowList.add(MenuUtils.createMenuRow(buttonText, Commands.MAIN_OPTIONS.toString()));
    }
}
