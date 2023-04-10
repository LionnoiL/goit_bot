package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.database.Service.BANK_SERVICE;
import static ua.dpw.telegrambots.bot.services.Emoji.HOUSE;
import static ua.dpw.telegrambots.bot.services.Emoji.WHITE_HEAVY_CHECK_MARK;

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
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        addRow1(rowList, userMessage);
        addRow2(rowList, userMessage);
        addRow3(rowList, userMessage);
        addRow4(rowList, userMessage);
        addRow5(rowList, userMessage);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    private String getButtonText(Bank bank, UserMessage userMessage, String languageText) {
        Bank userBank = userMessage.getUser().getBank();
        String emoji = bank.equals(userBank) ? WHITE_HEAVY_CHECK_MARK.toString() : "";
        return emoji + userMessage.getUser().getTranslate(languageText);
    }

    private void addRow1(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(BANK_SERVICE.getByName("PRIVATBANK"), userMessage, "PRIVATBANK"),
            Commands.BANK_PRIVATBANK.toString()
        );
        rowList.add(menuRow);
    }

    private void addRow2(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(BANK_SERVICE.getByName("MONOBANK"), userMessage, "MONOBANK"),
            Commands.BANK_MONOBANK.toString()
        );
        rowList.add(menuRow);
    }

    private void addRow3(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(BANK_SERVICE.getByName("OSCHADBANK"), userMessage, "OSCHADBANK"),
            Commands.BANK_OSCHADBANK.toString()
        );
        rowList.add(menuRow);
    }

    private void addRow4(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        List<InlineKeyboardButton> menuRow = MenuUtils.createMenuRow(
            getButtonText(BANK_SERVICE.getByName("NBU"), userMessage, "NBU"),
            Commands.BANK_NBU.toString());
        rowList.add(menuRow);
    }

    private void addRow5(List<List<InlineKeyboardButton>> rowList, UserMessage userMessage) {
        rowList.add(MenuUtils.createMenuRow(
            userMessage.getUser().getTranslate("BACK"),
            Commands.MAIN_OPTIONS.toString(),
            HOUSE.toString() + userMessage.getUser().getTranslate("HOME"),
            Commands.MAIN_MENU.toString()
        ));
    }
}
