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

public class NotificationMenu implements TelegramMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        addRow1(rowList, userMessage);
        addRow2(rowList, userMessage);
        addRow3(rowList, userMessage);
        addRow4(rowList, userMessage);
        addRow5(rowList, userMessage);
        addRow6(rowList, userMessage);

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    private InlineKeyboardButton createButton(UserMessage userMessage, int hour,
        String langButtonText, String callBack) {
        int notificationTime = userMessage.getUser().getAlertTime();
        String emoji = notificationTime == hour ? MARK_EMOJI : "";
        String buttonText = emoji + userMessage.getUser().getLanguage().get(langButtonText);
        return MenuUtils.createButton(buttonText, callBack);
    }

    private void addRow1(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String buttonText = userMessage.getUser().getLanguage().get("OPTIONS_USERTIME");
        rowList.add(MenuUtils.createMenuRow(buttonText, Commands.OPTIONS_USERTIME.toString()));
    }

    private void addRow2(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(createButton(userMessage, 9, "ALERT_9", Commands.ALERT_9.toString()));
        row.add(createButton(userMessage, 10, "ALERT_10", Commands.ALERT_10.toString()));
        row.add(createButton(userMessage, 11, "ALERT_11", Commands.ALERT_11.toString()));
        rowList.add(row);
    }

    private void addRow3(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(createButton(userMessage, 12, "ALERT_12", Commands.ALERT_12.toString()));
        row.add(createButton(userMessage, 13, "ALERT_13", Commands.ALERT_13.toString()));
        row.add(createButton(userMessage, 14, "ALERT_14", Commands.ALERT_14.toString()));
        rowList.add(row);
    }

    private void addRow4(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(createButton(userMessage, 15, "ALERT_15", Commands.ALERT_15.toString()));
        row.add(createButton(userMessage, 16, "ALERT_16", Commands.ALERT_16.toString()));
        row.add(createButton(userMessage, 17, "ALERT_17", Commands.ALERT_17.toString()));
        rowList.add(row);
    }

    private void addRow5(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(createButton(userMessage, 18, "ALERT_18", Commands.ALERT_18.toString()));
        row.add(createButton(userMessage, 100, "ALERT_OFF", Commands.ALERT_OFF.toString()));
        rowList.add(row);
    }

    private void addRow6(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String buttonText = userMessage.getUser().getLanguage().get("BACK");
        rowList.add(MenuUtils.createMenuRow(buttonText, Commands.MAIN_OPTIONS.toString()));
    }
}
