package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.properties.ApplicationProperties.MARK_EMOJI;
import static ua.dpw.telegrambots.bot.services.Emoji.HOUSE;
import static ua.dpw.telegrambots.bot.services.Emoji.WHITE_HEAVY_CHECK_MARK;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.currency.currencies.Currency;
import ua.dpw.telegrambots.bot.menus.MenuUtils;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class CurrencyMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        addRow1(rowList, userMessage);
        addRow2(rowList, userMessage);
        addRow3(rowList, userMessage);
        addRow4(rowList, userMessage);
        addRow5(rowList, userMessage);

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    private String getButtonText(Currency currency, UserMessage userMessage, String languageText){
        List<Currency> userCurrencies = userMessage.getUser().getCurrencies();
        String emoji = userCurrencies.contains(currency) ?  WHITE_HEAVY_CHECK_MARK.toString() : "";
        return emoji + userMessage.getUser().getLanguage().get(languageText);
    }

    private void addRow1(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(Currency.USD, userMessage, "CURRENCY_USD"),
            Commands.CURRENCY_USD.toString()
        );
        rowList.add(menuRow);
    }

    private void addRow2(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(Currency.EUR, userMessage, "CURRENCY_EUR"),
            Commands.CURRENCY_EUR.toString()
        );
        rowList.add(menuRow);
    }

    private void addRow3(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(Currency.BITCOIN, userMessage, "BITCOIN"),
            Commands.CURRENCY_BITCOIN.toString()
        );
        rowList.add(menuRow);
    }

    private void addRow4(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(Currency.ETHEREUM, userMessage, "ETHEREUM"),
            Commands.CURRENCY_ETHEREUM.toString());
        rowList.add(menuRow);
    }

    private void addRow5(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        rowList.add(MenuUtils.createMenuRow(
            userMessage.getUser().getLanguage().get("BACK"),
            Commands.MAIN_OPTIONS.toString(),
            HOUSE.toString() + userMessage.getUser().getLanguage().get("HOME"),
            Commands.MAIN_MENU.toString()
        ));
    }
}
