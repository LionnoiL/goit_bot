package ua.dpw.telegrambots.currencybot.menus;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.notifications.Scheduler;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

import java.util.ArrayList;
import java.util.List;

import static ua.dpw.properties.ApplicationProperties.MARK_EMOJI;

public class UserTimeMenu {
    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        int userTime = Scheduler.getCurrentHour() + userMessage.getUser().getDeltaHours();

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();
        List<InlineKeyboardButton> row5 = new ArrayList<>();
        List<InlineKeyboardButton> row6 = new ArrayList<>();

        InlineKeyboardButton userTime0 = new InlineKeyboardButton(
                (userTime == 0 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_0"));
        userTime0.setCallbackData(Commands.TIME_0.toString());
        InlineKeyboardButton userTime1 = new InlineKeyboardButton(
                (userTime == 1 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_1"));
        userTime1.setCallbackData(Commands.TIME_1.toString());
        InlineKeyboardButton userTime2 = new InlineKeyboardButton(
                (userTime == 2 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_2"));
        userTime2.setCallbackData(Commands.TIME_2.toString());
        InlineKeyboardButton userTime3 = new InlineKeyboardButton(
                (userTime == 3 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_3"));
        userTime3.setCallbackData(Commands.TIME_3.toString());
        InlineKeyboardButton userTime4 = new InlineKeyboardButton(
                (userTime == 4 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_4"));
        userTime4.setCallbackData(Commands.TIME_4.toString());

        InlineKeyboardButton userTime5 = new InlineKeyboardButton(
                (userTime == 5 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_5"));
        userTime5.setCallbackData(Commands.TIME_5.toString());
        InlineKeyboardButton userTime6 = new InlineKeyboardButton(
                (userTime == 6 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_6"));
        userTime6.setCallbackData(Commands.TIME_6.toString());
        InlineKeyboardButton userTime7 = new InlineKeyboardButton(
                (userTime == 7 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_7"));
        userTime7.setCallbackData(Commands.TIME_7.toString());
        InlineKeyboardButton userTime8 = new InlineKeyboardButton(
                (userTime == 8 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_8"));
        userTime8.setCallbackData(Commands.TIME_8.toString());
        InlineKeyboardButton userTime9 = new InlineKeyboardButton(
                (userTime == 9 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_9"));
        userTime9.setCallbackData(Commands.TIME_9.toString());

        InlineKeyboardButton userTime10 = new InlineKeyboardButton(
                (userTime == 10 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_10"));
        userTime10.setCallbackData(Commands.TIME_10.toString());
        InlineKeyboardButton userTime11 = new InlineKeyboardButton(
                (userTime == 11 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_11"));
        userTime11.setCallbackData(Commands.TIME_11.toString());
        InlineKeyboardButton userTime12 = new InlineKeyboardButton(
                (userTime == 12 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_12"));
        userTime12.setCallbackData(Commands.TIME_12.toString());
        InlineKeyboardButton userTime13 = new InlineKeyboardButton(
                (userTime == 13 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_13"));
        userTime13.setCallbackData(Commands.TIME_13.toString());
        InlineKeyboardButton userTime14 = new InlineKeyboardButton(
                (userTime == 14 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_14"));
        userTime14.setCallbackData(Commands.TIME_14.toString());

        InlineKeyboardButton userTime15 = new InlineKeyboardButton(
                (userTime == 15 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_15"));
        userTime15.setCallbackData(Commands.TIME_15.toString());
        InlineKeyboardButton userTime16 = new InlineKeyboardButton(
                (userTime == 16 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_16"));
        userTime16.setCallbackData(Commands.TIME_16.toString());
        InlineKeyboardButton userTime17 = new InlineKeyboardButton(
                (userTime == 17 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_17"));
        userTime17.setCallbackData(Commands.TIME_17.toString());
        InlineKeyboardButton userTime18 = new InlineKeyboardButton(
                (userTime == 18 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_18"));
        userTime18.setCallbackData(Commands.TIME_18.toString());
        InlineKeyboardButton userTime19 = new InlineKeyboardButton(
                (userTime == 19 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_19"));
        userTime19.setCallbackData(Commands.TIME_19.toString());

        InlineKeyboardButton userTime20 = new InlineKeyboardButton(
                (userTime == 20 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_20"));
        userTime20.setCallbackData(Commands.TIME_20.toString());
        InlineKeyboardButton userTime21 = new InlineKeyboardButton(
                (userTime == 21 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_21"));
        userTime21.setCallbackData(Commands.TIME_21.toString());
        InlineKeyboardButton userTime22 = new InlineKeyboardButton(
                (userTime == 22 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_22"));
        userTime22.setCallbackData(Commands.TIME_22.toString());
        InlineKeyboardButton userTime23 = new InlineKeyboardButton(
                (userTime == 23 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                        .get("TIME_23"));
        userTime23.setCallbackData(Commands.TIME_23.toString());

        InlineKeyboardButton buttonBack = new InlineKeyboardButton(
                userMessage.getUser().getLanguage().get("BACK"));
        buttonBack.setCallbackData(Commands.MAIN_OPTIONS.toString());

        row1.add(userTime0);
        row1.add(userTime1);
        row1.add(userTime2);
        row1.add(userTime3);
        row1.add(userTime4);

        row2.add(userTime5);
        row2.add(userTime6);
        row2.add(userTime7);
        row2.add(userTime8);
        row2.add(userTime9);

        row3.add(userTime10);
        row3.add(userTime11);
        row3.add(userTime12);
        row3.add(userTime13);
        row3.add(userTime14);

        row4.add(userTime15);
        row4.add(userTime16);
        row4.add(userTime17);
        row4.add(userTime18);
        row4.add(userTime19);

        row5.add(userTime20);
        row5.add(userTime21);
        row5.add(userTime22);
        row5.add(userTime23);

        row6.add(buttonBack);

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        rowList.add(row6);
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
