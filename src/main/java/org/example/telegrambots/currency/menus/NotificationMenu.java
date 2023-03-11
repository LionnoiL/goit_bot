package org.example.telegrambots.currency.menus;

import org.example.language.LanguageSwitcher;
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
        InlineKeyboardButton alert9 = new InlineKeyboardButton((notificationTime == 9 ? markEmoji : "") + LanguageSwitcher.currentLanguage.get("ALERT_9"));
        alert9.setCallbackData(Commands.ALERT_9.toString());
        InlineKeyboardButton alert10 = new InlineKeyboardButton((notificationTime == 10 ? markEmoji : "") + LanguageSwitcher.currentLanguage.get("ALERT_10"));
        alert10.setCallbackData(Commands.ALERT_10.toString());
        InlineKeyboardButton alert11 = new InlineKeyboardButton((notificationTime == 11 ? markEmoji : "") + LanguageSwitcher.currentLanguage.get("ALERT_11"));
        alert11.setCallbackData(Commands.ALERT_11.toString());
        row1.add(alert9);
        row1.add(alert10);
        row1.add(alert11);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton alert12 = new InlineKeyboardButton((notificationTime == 12 ? markEmoji : "") + LanguageSwitcher.currentLanguage.get("ALERT_12"));
        alert12.setCallbackData(Commands.ALERT_12.toString());
        InlineKeyboardButton alert13 = new InlineKeyboardButton((notificationTime == 13 ? markEmoji : "") + LanguageSwitcher.currentLanguage.get("ALERT_13"));
        alert13.setCallbackData(Commands.ALERT_13.toString());
        InlineKeyboardButton alert14 = new InlineKeyboardButton((notificationTime == 14 ? markEmoji : "") + LanguageSwitcher.currentLanguage.get("ALERT_14"));
        alert14.setCallbackData(Commands.ALERT_14.toString());
        row2.add(alert12);
        row2.add(alert13);
        row2.add(alert14);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton alert15 = new InlineKeyboardButton((notificationTime == 15 ? markEmoji : "") + LanguageSwitcher.currentLanguage.get("ALERT_15"));
        alert15.setCallbackData(Commands.ALERT_15.toString());
        InlineKeyboardButton alert16 = new InlineKeyboardButton((notificationTime == 16 ? markEmoji : "") + LanguageSwitcher.currentLanguage.get("ALERT_16"));
        alert16.setCallbackData(Commands.ALERT_16.toString());
        InlineKeyboardButton alert17 = new InlineKeyboardButton((notificationTime == 17 ? markEmoji : "") + LanguageSwitcher.currentLanguage.get("ALERT_17"));
        alert17.setCallbackData(Commands.ALERT_17.toString());
        row3.add(alert15);
        row3.add(alert16);
        row3.add(alert17);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton alert18 = new InlineKeyboardButton((notificationTime == 18 ? markEmoji : "") + LanguageSwitcher.currentLanguage.get("ALERT_18"));
        alert18.setCallbackData(Commands.ALERT_18.toString());
        InlineKeyboardButton alertOff = new InlineKeyboardButton((notificationTime == 100 ? markEmoji : "") + LanguageSwitcher.currentLanguage.get("ALERT_OFF"));
        alertOff.setCallbackData(Commands.ALERT_OFF.toString());
        row4.add(alert18);
        row4.add(alertOff);

        List<InlineKeyboardButton> row5 = new ArrayList<>();
        InlineKeyboardButton buttonBack = new InlineKeyboardButton(LanguageSwitcher.currentLanguage.get("BACK"));
        buttonBack.setCallbackData(Commands.MAIN_OPTIONS.toString());
        row5.add(buttonBack);

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
