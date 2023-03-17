package ua.dpw.telegrambots.currencybot.menus;

import static ua.dpw.properties.ApplicationProperties.MARK_EMOJI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ua.dpw.currency.bank.Bank;
import ua.dpw.currency.services.CurrencyRateCryptoService;
import ua.dpw.telegrambots.bot.menus.TelegramMenu;
import ua.dpw.telegrambots.bot.services.UserMessage;
import ua.dpw.telegrambots.currencybot.commands.Commands;

public class BankMenu implements TelegramMenu {

    public InlineKeyboardMarkup createMenu(UserMessage userMessage){
        Bank bank = userMessage.getUser().getBank();

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();
        List<InlineKeyboardButton> row5 = new ArrayList<>();
        List<InlineKeyboardButton> row6 = new ArrayList<>();

        InlineKeyboardButton buttonPrivatbank = new InlineKeyboardButton(
            (Bank.PRIVATBANK.equals(bank) ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("PRIVATBANK"));
        buttonPrivatbank.setCallbackData(Commands.BANK_PRIVATBANK.toString());

        InlineKeyboardButton buttonMonobank = new InlineKeyboardButton(
            (Bank.MONOBANK.equals(bank) ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("MONOBANK"));
        buttonMonobank.setCallbackData(Commands.BANK_MONOBANK.toString());

        InlineKeyboardButton buttonOschad = new InlineKeyboardButton(
            (Bank.OSCHADBANK.equals(bank) ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("OSCHADBANK"));
        buttonOschad.setCallbackData(Commands.BANK_OSCHADBANK.toString());

        InlineKeyboardButton buttonNbu = new InlineKeyboardButton(
            (Bank.NBU.equals(bank) ? MARK_EMOJI : "") + userMessage.getUser().getLanguage()
                .get("NBU"));
        buttonNbu.setCallbackData(Commands.BANK_NBU.toString());

        InlineKeyboardButton buttonBack = new InlineKeyboardButton(
            userMessage.getUser().getLanguage().get("BACK"));
        buttonBack.setCallbackData(Commands.MAIN_OPTIONS.toString());

        row1.add(buttonPrivatbank);
        row2.add(buttonMonobank);
        row3.add(buttonOschad);
        row4.add(buttonNbu);
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
