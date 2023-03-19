package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.properties.ApplicationProperties.MARK_EMOJI;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.currency.bank.Bank;
import ua.dpw.telegrambots.bot.menus.MenuUtils;
import ua.dpw.telegrambots.bot.menus.TelegramMenu;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class BankMenu implements TelegramMenu {

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

    private String getButtonText(Bank bank, UserMessage userMessage, String languageText) {
        Bank userBank = userMessage.getUser().getBank();
        String emoji = bank.equals(userBank) ? MARK_EMOJI : "";
        return emoji + userMessage.getUser().getLanguage().get(languageText);
    }

    private void addRow1(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(Bank.PRIVATBANK, userMessage, "PRIVATBANK"),
            Commands.BANK_PRIVATBANK.toString()
        );
        rowList.add(menuRow);
    }

    private void addRow2(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(Bank.MONOBANK, userMessage, "MONOBANK"),
            Commands.BANK_MONOBANK.toString()
        );
        rowList.add(menuRow);
    }

    private void addRow3(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(Bank.OSCHADBANK, userMessage, "OSCHADBANK"),
            Commands.BANK_OSCHADBANK.toString()
        );
        rowList.add(menuRow);
    }

    private void addRow4(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(Bank.NBU, userMessage, "NBU"),
            Commands.BANK_NBU.toString());
        rowList.add(menuRow);
    }

    private void addRow5(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        String buttonText = userMessage.getUser().getLanguage().get("BACK");
        rowList.add(MenuUtils.createMenuRow(buttonText, Commands.MAIN_OPTIONS.toString()));
    }
}
