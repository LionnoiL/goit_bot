package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.properties.ApplicationProperties.MARK_EMOJI;

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

    private void addRow1(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<Currency> currencies = userMessage.getUser().getCurrencies();
        String emoji = currencies.contains(Currency.USD) ? MARK_EMOJI : "";
        String buttonText = emoji + userMessage.getUser().getLanguage().get("CURRENCY_USD");
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(buttonText,
            Commands.CURRENCY_USD.toString());
        rowList.add(menuRow);
    }

    private void addRow2(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<Currency> currencies = userMessage.getUser().getCurrencies();
        String emoji = currencies.contains(Currency.EUR) ? MARK_EMOJI : "";
        String buttonText = emoji + userMessage.getUser().getLanguage().get("CURRENCY_EUR");
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(buttonText,
            Commands.CURRENCY_EUR.toString());
        rowList.add(menuRow);
    }

    private void addRow3(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<Currency> currencies = userMessage.getUser().getCurrencies();
        String emoji = currencies.contains(Currency.BITCOIN) ? MARK_EMOJI : "";
        String buttonText = emoji + userMessage.getUser().getLanguage().get("BITCOIN");
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(buttonText,
            Commands.CURRENCY_BITCOIN.toString());
        rowList.add(menuRow);
    }

    private void addRow4(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<Currency> currencies = userMessage.getUser().getCurrencies();
        String emoji = currencies.contains(Currency.ETHEREUM) ? MARK_EMOJI : "";
        String buttonText = emoji + userMessage.getUser().getLanguage().get("ETHEREUM");
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(buttonText,
            Commands.CURRENCY_ETHEREUM.toString());
        rowList.add(menuRow);
    }

    private void addRow5(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String buttonText = userMessage.getUser().getLanguage().get("BACK");
        rowList.add(MenuUtils.createMenuRow(buttonText, Commands.MAIN_OPTIONS.toString()));
    }
}
