package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.properties.ApplicationProperties.MARK_EMOJI;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.telegrambots.bot.menus.TelegramMenu;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class LanguageMenu implements TelegramMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {

        String langCode = userMessage.getUser().getLangCode();

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();

        InlineKeyboardButton uaButton = new InlineKeyboardButton(
            ("uk".equals(langCode) ? MARK_EMOJI : "") +
                userMessage.getUser().getLanguage().get("UA_BUTTON"));
        uaButton.setCallbackData(Commands.UA_BUTTON.toString());

        InlineKeyboardButton enButton = new InlineKeyboardButton(
            ("en".equals(langCode) ? MARK_EMOJI : "") +
                userMessage.getUser().getLanguage().get("EN_BUTTON"));
        enButton.setCallbackData(Commands.EN_BUTTON.toString());

        InlineKeyboardButton plButton = new InlineKeyboardButton(
            ("pl".equals(langCode) ? MARK_EMOJI : "") +
                userMessage.getUser().getLanguage().get("PL_BUTTON"));
        plButton.setCallbackData(Commands.PL_BUTTON.toString());

        InlineKeyboardButton buttonBack = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("BACK"));
        buttonBack.setCallbackData(Commands.MAIN_OPTIONS.toString());

        row1.add(uaButton);
        row2.add(enButton);
        row3.add(plButton);
        row4.add(buttonBack);

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
