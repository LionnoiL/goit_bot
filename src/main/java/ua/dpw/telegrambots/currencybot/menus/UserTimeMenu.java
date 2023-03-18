package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.properties.ApplicationProperties.MARK_EMOJI;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.notifications.Scheduler;
import ua.dpw.telegrambots.bot.menus.MenuUtils;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class UserTimeMenu {

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
        int userTime = Scheduler.getCurrentHour() + userMessage.getUser().getDeltaHours();
        String emoji = hour == userTime ? MARK_EMOJI : "";
        String buttonText = emoji + userMessage.getUser().getLanguage().get(langButtonText);
        return MenuUtils.createButton(buttonText, callBack);
    }

    private void addRow1(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(createButton(userMessage, 0, "TIME_0", Commands.TIME_0.toString()));
        row.add(createButton(userMessage, 1, "TIME_1", Commands.TIME_1.toString()));
        row.add(createButton(userMessage, 2, "TIME_2", Commands.TIME_2.toString()));
        row.add(createButton(userMessage, 3, "TIME_3", Commands.TIME_3.toString()));
        row.add(createButton(userMessage, 4, "TIME_4", Commands.TIME_4.toString()));
        rowList.add(row);
    }

    private void addRow2(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(createButton(userMessage, 5, "TIME_5", Commands.TIME_5.toString()));
        row.add(createButton(userMessage, 6, "TIME_6", Commands.TIME_6.toString()));
        row.add(createButton(userMessage, 7, "TIME_7", Commands.TIME_7.toString()));
        row.add(createButton(userMessage, 8, "TIME_8", Commands.TIME_8.toString()));
        row.add(createButton(userMessage, 9, "TIME_9", Commands.TIME_9.toString()));
        rowList.add(row);
    }

    private void addRow3(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(createButton(userMessage, 10, "TIME_10", Commands.TIME_10.toString()));
        row.add(createButton(userMessage, 11, "TIME_11", Commands.TIME_11.toString()));
        row.add(createButton(userMessage, 12, "TIME_12", Commands.TIME_12.toString()));
        row.add(createButton(userMessage, 13, "TIME_13", Commands.TIME_13.toString()));
        row.add(createButton(userMessage, 14, "TIME_14", Commands.TIME_14.toString()));
        rowList.add(row);
    }

    private void addRow4(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(createButton(userMessage, 15, "TIME_15", Commands.TIME_15.toString()));
        row.add(createButton(userMessage, 16, "TIME_16", Commands.TIME_16.toString()));
        row.add(createButton(userMessage, 17, "TIME_17", Commands.TIME_17.toString()));
        row.add(createButton(userMessage, 18, "TIME_18", Commands.TIME_18.toString()));
        row.add(createButton(userMessage, 19, "TIME_19", Commands.TIME_19.toString()));
        rowList.add(row);
    }

    private void addRow5(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(createButton(userMessage, 20, "TIME_20", Commands.TIME_20.toString()));
        row.add(createButton(userMessage, 21, "TIME_21", Commands.TIME_21.toString()));
        row.add(createButton(userMessage, 22, "TIME_22", Commands.TIME_22.toString()));
        row.add(createButton(userMessage, 23, "TIME_23", Commands.TIME_23.toString()));
        rowList.add(row);
    }

    private void addRow6(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String buttonText = userMessage.getUser().getLanguage().get("BACK");
        rowList.add(MenuUtils.createMenuRow(buttonText, Commands.OPTIONS_NOTIFICATIONS.toString()));
    }
}
