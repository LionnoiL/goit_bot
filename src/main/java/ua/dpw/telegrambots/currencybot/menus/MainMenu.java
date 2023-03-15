package ua.dpw.telegrambots.currencybot.menus;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.currency.services.CurrencyRateCryptoService;
import ua.dpw.telegrambots.bot.menus.TelegramMenu;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class MainMenu implements TelegramMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();

        InlineKeyboardButton getInfoButton = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("MAIN_GET_INFO"));
        getInfoButton.setCallbackData(Commands.MAIN_GET_INFO.toString());

        InlineKeyboardButton getInfoCrypto = new InlineKeyboardButton(
                userMessage.getUser().getLanguage().get("CRYPTOCURRENCY"));
        getInfoCrypto.setCallbackData(Commands.CURRYNCY_CRYPTO.toString());

        InlineKeyboardButton getOptionsButton = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("MAIN_OPTIONS"));
        getOptionsButton.setCallbackData(Commands.MAIN_OPTIONS.toString());

        row1.add(getInfoButton);
        row2.add(getInfoCrypto);
        row3.add(getOptionsButton);

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
