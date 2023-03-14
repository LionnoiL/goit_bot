package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.properties.ApplicationProperties.MARK_EMOJI;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.telegrambots.bot.menus.TelegramMenu;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class ChoiceNumberSymbolMenu implements TelegramMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        int symbolsAfterComma = userMessage.getUser().getSymbolsAfterComma();

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();

        InlineKeyboardButton button2 = new InlineKeyboardButton(
            (symbolsAfterComma == 2 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("NUMBERS_2"));
        button2.setCallbackData(Commands.NUMBERS_2.toString());

        InlineKeyboardButton button3 = new InlineKeyboardButton(
            (symbolsAfterComma == 3 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("NUMBERS_3"));
        button3.setCallbackData(Commands.NUMBERS_3.toString());

        InlineKeyboardButton button4 = new InlineKeyboardButton(
            (symbolsAfterComma == 4 ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("NUMBERS_4"));
        button4.setCallbackData(Commands.NUMBERS_4.toString());

        InlineKeyboardButton buttonBack = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("BACK"));
        buttonBack.setCallbackData(Commands.MAIN_OPTIONS.toString());

        row1.add(button2);
        row2.add(button3);
        row3.add(button4);
        row4.add(buttonBack);

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
