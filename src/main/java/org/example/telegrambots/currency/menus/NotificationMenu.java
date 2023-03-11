package org.example.telegrambots.currency.menus;

import org.example.telegrambots.bot.menus.TelegramMenu;
import org.example.telegrambots.bot.services.UserMessage;
import org.example.telegrambots.currency.commands.Commands;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class NotificationMenu implements TelegramMenu {
    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        int notificationTime = userMessage.getUser().getAlertTime();
        String markEmoji = "✔";

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton alert9 = new InlineKeyboardButton((notificationTime == 9 ? markEmoji : "") + Commands.ALERT_9.getButtonText());
        alert9.setCallbackData(Commands.ALERT_9.toString());
        InlineKeyboardButton alert10 = new InlineKeyboardButton((notificationTime == 10 ? markEmoji : "") + Commands.ALERT_10.getButtonText());
        alert10.setCallbackData(Commands.ALERT_10.toString());
        InlineKeyboardButton alert11 = new InlineKeyboardButton((notificationTime == 11 ? markEmoji : "") + Commands.ALERT_11.getButtonText());
        alert11.setCallbackData(Commands.ALERT_11.toString());
        row1.add(alert9);
        row1.add(alert10);
        row1.add(alert11);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton alert12 = new InlineKeyboardButton((notificationTime == 12 ? markEmoji : "") + Commands.ALERT_12.getButtonText());
        alert12.setCallbackData(Commands.ALERT_12.toString());
        InlineKeyboardButton alert13 = new InlineKeyboardButton((notificationTime == 13 ? markEmoji : "") + Commands.ALERT_13.getButtonText());
        alert13.setCallbackData(Commands.ALERT_13.toString());
        InlineKeyboardButton alert14 = new InlineKeyboardButton((notificationTime == 14 ? markEmoji : "") + Commands.ALERT_14.getButtonText());
        alert14.setCallbackData(Commands.ALERT_14.toString());
        row2.add(alert12);
        row2.add(alert13);
        row2.add(alert14);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton alert15 = new InlineKeyboardButton((notificationTime == 15 ? markEmoji : "") + Commands.ALERT_15.getButtonText());
        alert15.setCallbackData(Commands.ALERT_15.toString());
        InlineKeyboardButton alert16 = new InlineKeyboardButton((notificationTime == 16 ? markEmoji : "") + Commands.ALERT_16.getButtonText());
        alert16.setCallbackData(Commands.ALERT_16.toString());
        InlineKeyboardButton alert17 = new InlineKeyboardButton((notificationTime == 17 ? markEmoji : "") + Commands.ALERT_17.getButtonText());
        alert17.setCallbackData(Commands.ALERT_17.toString());
        row3.add(alert15);
        row3.add(alert16);
        row3.add(alert17);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton alert18 = new InlineKeyboardButton((notificationTime == 18 ? markEmoji : "") + Commands.ALERT_18.getButtonText());
        alert18.setCallbackData(Commands.ALERT_18.toString());
        InlineKeyboardButton alertOff = new InlineKeyboardButton(Commands.ALERT_OFF.getButtonText());
        alertOff.setCallbackData(Commands.ALERT_OFF.toString());
        InlineKeyboardButton buttonBack = new InlineKeyboardButton(Commands.BACK.getButtonText());
        buttonBack.setCallbackData(Commands.MAIN_OPTIONS.toString());
        row4.add(alert18);
        row4.add(alertOff);
        row4.add(buttonBack);

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
