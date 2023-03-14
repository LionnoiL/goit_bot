package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.properties.ApplicationProperties.MARK_EMOJI;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.telegrambots.bot.menus.TelegramMenu;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class NotificationMenu implements TelegramMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        int notificationTime = userMessage.getUser().getAlertTime();

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();
        List<InlineKeyboardButton> row5 = new ArrayList<>();

        InlineKeyboardButton alert9 = new InlineKeyboardButton(
            (notificationTime == 9 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("ALERT_9"));
        alert9.setCallbackData(Commands.ALERT_9.toString());
        InlineKeyboardButton alert10 = new InlineKeyboardButton(
            (notificationTime == 10 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("ALERT_10"));
        alert10.setCallbackData(Commands.ALERT_10.toString());
        InlineKeyboardButton alert11 = new InlineKeyboardButton(
            (notificationTime == 11 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("ALERT_11"));
        alert11.setCallbackData(Commands.ALERT_11.toString());

        InlineKeyboardButton alert12 = new InlineKeyboardButton(
            (notificationTime == 12 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("ALERT_12"));
        alert12.setCallbackData(Commands.ALERT_12.toString());
        InlineKeyboardButton alert13 = new InlineKeyboardButton(
            (notificationTime == 13 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("ALERT_13"));
        alert13.setCallbackData(Commands.ALERT_13.toString());
        InlineKeyboardButton alert14 = new InlineKeyboardButton(
            (notificationTime == 14 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("ALERT_14"));
        alert14.setCallbackData(Commands.ALERT_14.toString());

        InlineKeyboardButton alert15 = new InlineKeyboardButton(
            (notificationTime == 15 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("ALERT_15"));
        alert15.setCallbackData(Commands.ALERT_15.toString());
        InlineKeyboardButton alert16 = new InlineKeyboardButton(
            (notificationTime == 16 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("ALERT_16"));
        alert16.setCallbackData(Commands.ALERT_16.toString());
        InlineKeyboardButton alert17 = new InlineKeyboardButton(
            (notificationTime == 17 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("ALERT_17"));
        alert17.setCallbackData(Commands.ALERT_17.toString());

        InlineKeyboardButton alert18 = new InlineKeyboardButton(
            (notificationTime == 18 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("ALERT_18"));
        alert18.setCallbackData(Commands.ALERT_18.toString());
        InlineKeyboardButton alertOff = new InlineKeyboardButton(
            (notificationTime == 100 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("ALERT_OFF"));
        alertOff.setCallbackData(Commands.ALERT_OFF.toString());

        InlineKeyboardButton buttonBack = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("BACK"));
        buttonBack.setCallbackData(Commands.MAIN_OPTIONS.toString());

        row1.add(alert9);
        row1.add(alert10);
        row1.add(alert11);

        row2.add(alert12);
        row2.add(alert13);
        row2.add(alert14);

        row3.add(alert15);
        row3.add(alert16);
        row3.add(alert17);

        row4.add(alert18);
        row4.add(alertOff);
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
